package com.s3.example.s3service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class S3ServiceApplication

fun main(args: Array<String>) {
    runApplication<S3ServiceApplication>(*args)
}
