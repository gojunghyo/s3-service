package com.s3.example.s3service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class S3ServiceApplicationTests {

    @Test
    fun contextLoads() {
        println("TEST")
        Assertions.assertThat(1).isEqualTo(1)
    }

}
