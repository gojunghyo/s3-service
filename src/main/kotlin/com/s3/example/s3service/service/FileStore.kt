package com.s3.example.s3service.service

import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.*

interface FileStore {

    @Throws(IOException::class)
    fun save(fileName: String,
            file: MultipartFile) : String

    @Throws(IOException::class)
    fun download(fileName: String): ResponseEntity<ByteArray>

}
