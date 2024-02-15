package com.s3.example.s3service.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "file-store")
class ShareFileStoreProperties{

    lateinit var bucketName: String

    lateinit var uploadPath: String
}
