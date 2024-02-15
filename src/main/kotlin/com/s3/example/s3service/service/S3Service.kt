package com.s3.example.s3service.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.s3.example.s3service.config.ShareFileStoreProperties
import com.s3.example.s3service.exception.UploadFileException
import org.apache.http.entity.ContentType
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream

@Service
class S3Service(
    @Autowired val s3client: AmazonS3,
    @Autowired val shareFileStoreProperties: ShareFileStoreProperties
) : FileStore{

    fun imgUpload(files: List<MultipartFile>): List<String> {
        if(files.isEmpty()) throw UploadFileException("File is not empty")
        val list: MutableList<String> = mutableListOf()
        for (file in files) {
            if(validationImg(file)){
                val fileName = file.originalFilename ?: ""
                val savedPath = save(fileName, file)
                list.add(savedPath)
            }
        }
        println(list)
        return list
    }


    fun validationImg(file: MultipartFile): Boolean {
        return if(listOf(
                ContentType.IMAGE_BMP.mimeType,
                ContentType.IMAGE_JPEG.mimeType,
                ContentType.IMAGE_PNG.mimeType,
                ContentType.IMAGE_GIF.mimeType).contains(file.contentType) ||
                file.originalFilename !== ""
                ) {
           return true
        }else {
            throw IllegalStateException("BMP, JPG, JPEG, GIF, PNG 형식의 파일만 업로드 가능합니다. 파일 형식을 확인해 주세요" )
        }
    }

    override fun save(fileName: String, file: MultipartFile) : String {
        //경로 없을시 생성
        if (!s3client.doesObjectExist(shareFileStoreProperties.bucketName, shareFileStoreProperties.uploadPath)) {
            s3client.putObject(
                    shareFileStoreProperties.bucketName,
                    shareFileStoreProperties.uploadPath,
                    ByteArrayInputStream(ByteArray(0)),
                    ObjectMetadata()
            )
        }
        val metadata = ObjectMetadata()
        metadata.contentLength = file.bytes.size.toLong()
        metadata.cacheControl = "public, max-age=31536000"

        val savedPath = shareFileStoreProperties.uploadPath + fileName
        val putObjectReqest = PutObjectRequest(
                shareFileStoreProperties.bucketName,
                savedPath,
                file.inputStream,
                metadata
        )
        s3client.putObject(putObjectReqest)
        println("UPLOAD COMPLETE PATH = $savedPath")
        return savedPath
    }

    override fun download(fileName: String): ResponseEntity<ByteArray> {
        TODO("Not yet implemented")
    }
}
