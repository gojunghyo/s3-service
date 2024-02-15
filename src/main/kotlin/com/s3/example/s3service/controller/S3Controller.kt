package com.s3.example.s3service.controller

import com.s3.example.s3service.code.ResponseCode
import com.s3.example.s3service.dto.S3ResponseDto
import com.s3.example.s3service.service.S3Service
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/s3")

class S3Controller(
        @Autowired val s3Service: S3Service
) {

    /**
     * s3 img upload api
     */
    @PostMapping(path = ["/img/upload"],
                consumes = [MediaType.MULTIPART_FORM_DATA_VALUE],
                produces = [MediaType.APPLICATION_JSON_VALUE])
    fun imgUpload(@RequestParam("files") files: List<MultipartFile>) :ResponseEntity<S3ResponseDto> {
        var message = ResponseCode.IMAGE_UPLOAD_SUCCESS

        val imgUploadPath = s3Service.imgUpload(files)
        if(imgUploadPath.isEmpty()) message = ResponseCode.IMAGE_UPLOAD_FAIL
        val result = S3ResponseDto(message, imgUploadPath)

        return ResponseEntity(result, HttpStatus.OK)
    }

    /**
     * s3 img download api
     */
    @GetMapping("/img/download")
    fun imgDownload(
            @RequestParam("fileName") fileName: String
    ) {
        println("IN fileName = $fileName")
    }

}
