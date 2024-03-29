﻿# s3-service


## 기술 스택
```
프레임워크: Spring Boot 3.2.2
언어: Kotlin (JAVA 17)
빌드도구: Gradle 8.5
```

## 개발환경 구성

```
1. java 17 (Build Tools -> Gradle -> 17 셋팅)
2. file -> Project Settings -> Project Java 17 (corretto-17) Setting
3. gradle build
```

## S3 KEY 발급 및 버킷생성
```
1. accessKey
2. secretKey (accessKey 발급시 csv 파일에 존재)
3. Bucket Create
4. 해당 Bucket role 적용
```

## S3 KEY application.yml 등록
```
yml 파일에 등록하여 
AmazonConfig 파일에서 사용할수있도록 설정
```

## POST MAN  확인

# upload

1. <img width="452" alt="포스트맨업로드" src="https://github.com/gojunghyo/s3-service/assets/128199051/5237384d-5ecf-4f67-aaa3-e8be376f11fd">

2. ![확인_S3](https://github.com/gojunghyo/s3-service/assets/128199051/150c2467-7b33-43c4-95a0-8b86858c122c)


# download

1. ![업로드상태](https://github.com/gojunghyo/s3-service/assets/128199051/3a66a458-f83d-4f2c-84bd-74ea297f8921)

2. ![다운로드확인](https://github.com/gojunghyo/s3-service/assets/128199051/e13fcd6b-852e-4d92-bb81-c386afcc1e34)



# 마무리하며
```
파일 업로드시 경로와 파일명은 한글보다
영문으로 작성 (Unicode 관련)
```
