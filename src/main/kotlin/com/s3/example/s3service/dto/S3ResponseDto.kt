package com.s3.example.s3service.dto

import com.s3.example.s3service.code.ResponseCode

class S3ResponseDto(message: ResponseCode, imgUploadPath: List<String>) {

    val message = message
    val imageUploadPathList = imgUploadPath
}
