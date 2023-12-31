# bookRent Repository

### 프로젝트 설명
bookRent는 도서 대출 프로젝트입니다.
회원가입과 로그인 기능이 구현되어 있고, 로그인으로 받은 access token으로 인가를 받은 회원의 경우
도서 등록, 수정과 도서 대여, 반납, 도서에 대한 대여 이력 조회가 가능합니다.

### 사용 기술
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white">

<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/JPA-FF6600?style=for-the-badge&logo=JPA&logoColor=white"> 

<img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=white"> <img src="https://img.shields.io/badge/Spring Security-6DB33F?style=for-the-badge&logo=Spring Security&logoColor=white">

<img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JWT&logoColor=white"> <img src="https://img.shields.io/badge/intellijidea-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=Docker&logoColor=white"> 

<img src="https://img.shields.io/badge/amazon aws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"> <img src="https://img.shields.io/badge/amazon ec2-FF9900?style=for-the-badge&logo=amazonec2&logoColor=white"> <img src="https://img.shields.io/badge/amazon s3-569A31?style=for-the-badge&logo=amazons3&logoColor=white"> <img src="https://img.shields.io/badge/amazon IAM-FF9900?style=for-the-badge&logo=amazoniam&logoColor=white"> <img src="https://img.shields.io/badge/amazon vpc-DC382D?style=for-the-badge&logo=amazonvpc&logoColor=white"> <img src="https://img.shields.io/badge/amazon codedeploy-000000?style=for-the-badge&logo=amazoncodedeploy&logoColor=white"> 

### AWS 구성 내역
![aws 구성도](https://github.com/choitree/bookRent/assets/64007131/b9b6079e-5b57-4816-b86a-accfd2a1cad1)


### 배포 파이프라인(GITHUB ACTION)
![279900904-7caa85a9-0be4-4fce-bc3c-b8063209a1fe](https://github.com/choitree/bookRent/assets/64007131/5f04e756-abbe-42b2-91f8-ae65a005f410)


### 배포 url 및 request/response sample
[배포url](http://52.78.212.104)  

[postman](https://documenter.getpostman.com/view/15294373/2s9YkhikCY)에서 request/response 확인 가능합니다.

### Local로 실행 방법
#### Repository Clone
```
git clone https://github.com/choitree/bookRent.git
```

#### JDK 설치
JDK17(이)가 설치되어 있는 경우 사용 가능. JDK17을 설치해주세요.

#### Docker로 설치해야하는 환경
- MySQL

##### docker가 설치되어 있는 경우 사용 가능. docker를 설치해 주세요.

docker 설치: [Download Docker](https://www.docker.com/products/docker-desktop/)

```
cd bookRent/
docker-compose up -d
```

#### Local 실행
```
./gradlew bootJar
java -jar -Dspring.profiles.active=local ./build/libs/bookRent-0.0.1-SNAPSHOT.jar
```

