package com.s3.example.s3service.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AmazonConfig {

    /**
     * accesskey 는 IAM 엑세스키 생성후
     * CSV 다운로드시 secretkey와 같이 확인 가능
     * 해당 키에 s3 접근을 위한 role 을 적용해주어야함
     */

    @Value("\${aws-s3.accessKey}")
    lateinit var accessKey: String

    @Value("\${aws-s3.secretKey}")
    lateinit var secretKey: String

    @Bean
    fun s3(): AmazonS3 {
        val awsCredentials = BasicAWSCredentials(
                accessKey, secretKey
        )

        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.AP_NORTHEAST_2)
                .withCredentials(AWSStaticCredentialsProvider(awsCredentials))
                .build()
    }
}
