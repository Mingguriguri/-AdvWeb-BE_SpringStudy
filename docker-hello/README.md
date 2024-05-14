# [강의] w10 - Docker : hello

유형: Lecture
날짜: 2024년 5월 14일
복습 여부: No
상태: 완료

# Create project

- name : docker-hello
- java / gradle
- group: gcu.backend
- jdk: 17 (나는 21로 함)
- java: 17
- dependency
    - spring web
    - 나는 devtools도 추가함

<img width="912" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 15 09" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/1e1a93c2-a264-45e2-92fd-201fdfd0e3f7">
<img width="912" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 15 34" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/28bf8f83-f5bf-4444-a3c5-5fd2934f4aeb">


# Implementation & Build

- Add package controller and create HelloController.java
    <img width="396" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 25 34" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/f9d731cb-809d-4f93-84e2-20986172b3a2">

```java
package gcu.backend.dockerhello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
    @GetMapping("/hello")
    public String getMessage(){
        return "Hello World";
    }
}

```
<img width="967" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 26 56" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/849c4da7-4cc2-4e9e-bd68-bb681f9531f6">


- Run
    - 실행 버튼 누르거나 터미널창에 `./gradlew build` 입력
    <img width="792" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 29 43" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/e1add6f9-61ac-47a8-b8df-450ff6c17edc">
    
<img width="1534" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 19 58" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/3f2a2732-37b3-43d1-8372-d6961603f121">

그러면 교수님 자료에 나와있는 것처럼 `libs` 폴더가 생성됨
<img width="383" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 21 07" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/c0ae5596-391e-492c-a1b5-7816d9f7f34d">


# Create Dockerfile

- docker-hello - right mouse - new - file - dockerfile
    
    <img width="354" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 32 15" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/ed6b3690-a670-4331-a005-f9c222030ee5">


- write the script of `*Dockerfile*`
    
    ```docker
    FROM openjdk:21
    ARG JAR_FILE=build/libs/*.jar
    COPY ${JAR_FILE} app.jar
    ENTRYPOINT ["java", "-jar", "/app.jar"]
    ```
    <img width="967" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 34 21" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/f897d2f0-53b4-49ed-8e67-11d27b857d72">
    

# Create Docker images

- `docker images build -t app` 명령어를 터미널에서 실행한다. (이때 꼭 project안에서 명령을 실행해야 함 (우리 프로젝트는 docker-hello니까 여기서 실행해야 함)

<img width="1382" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_1 42 19" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/97369d41-ced0-4f55-8acc-8055e141ff77">


    - 그리고 중요한 것! docker desktop 실행해야 함

> **docker image를 build해주는 명령어**
> 
> 
> ```bash
> docker image build -t app .
> ```
> 
> - `-t` 태그: 이름을 설정하고, 이미지에 optionally하게 태그를 붙일 수 있게 하는 명령
> - 마지막에 있는 `.` : 이미지를 빌드하기 위한 Dockerfile과 다른 필수적인 파일을 현재 디렉토리에 위치하도록 설정한ㄷ.
<img width="1517" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 22 27" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/f70583b0-0f33-4908-a857-fde61179cf75">


잘 실행된 것을 확인할 수 있음.

> `docker images` 이 명령어는 docker image의 목록을 확인할 수 있다.
> 
> 
> ```bash
> docker images
> ```
> 
<img width="1517" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 22 55" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/5e87ae14-de27-4923-971e-356c0ae25d24">


또는 Docker desktop에서 체크할 수 있음!
<img width="1382" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 05 02" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/e579c47e-f2c8-415a-8c32-1c4249b36711">


> **docker 실행 명령어**
> 
> 
> ```bash
> docker run - d IMAGE_ID
> ```
> 
> - docker run 명령어는 도커 컨테이너를 실행하는데 사용된다.
> - `-d`는 “detach(분리)”를 의미한다.
> - 그래서 이 명령어는 백그라운드에서 컨테이너를 실행시하고 추가 명령을 위해 터미널을 확보한다.
> - 컨테이너를 실행하려는 도커 이미지 식별 정보로 `IMAGE_ID`를 업데이트한다.

실행시킬 때 `IMAGE_ID`는 중복되는 게 없다면 짧게 입력해도 가능함. 나는 `9c0f8dd9b06e` **를 실행시킬건데 중복되는게 없으니까 9c까지만 입력함
<img width="1517" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 23 32" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/ca514ca2-f29c-4036-befb-d87ae92fc16e">


아니면 docker desktop에서 실행해도 됨
<img width="1691" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 23 48" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/5e6d2d74-885c-448c-93a6-d5c2e809d9bd">
<img width="1691" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 23 55" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/10ce9d64-65a3-4093-b3e2-90bd194d14ac">
<img width="1691" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 24 08" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/877020cc-6559-4178-a56b-33c1846e5f63">


컨테이너 섹션에서도 실행중이라고 뜬다.
<img width="1691" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 24 19" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/0cdd1243-054c-48fd-8ebf-481ed34c2827">


이제 기본 포트 번호 8080에서 실행 중인 Docker 데스크톱 앱의 로그를 확인해보자

# 에러 발생!!

교수님이 알려주신대로 절차를 밟았지만 이런 화면이 떴다..
<img width="967" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 46 23" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/6d6105c5-1bc2-4896-9b79-b778de08ef69">


여기서는 **`docker run`** 명령어에 포트 매핑 옵션을 추가하고, Dockerfile에 포트를 노출하는 코드를 추가

1. **Dockerfile에 포트 노출 ( `EXPOSE 8080` ) 추가하고 저장**
    
    ```docker
    
    FROM openjdk:21
    ARG JAR_FILE=build/libs/*.jar
    COPY ${JAR_FILE} app.jar
    EXPOSE 8080 
    ENTRYPOINT ["java", "-jar", "/app.jar"]
    ```
    <img width="967" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 49 36" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/d0e1e567-7432-4016-b54c-a8defc57654c">

    
2. 이미지를 다시 빌드:
    
    ```bash
    docker image build -t app .
    ```
    <img width="1757" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 51 30" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/9cff7b7d-0a85-4e22-8cb5-a3d9dc9590bd">

    
    ```bash
    docker images
    ```
    <img width="1757" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 51 54" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/2c9f540b-4d8b-4035-b96b-f05aa58e2efa">

     
3. **컨테이너 실행:**
    
    ```bash
    docker run -d -p 8080:8080 app
    ```
    <img width="1757" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 52 28" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/689f2d70-b40a-489c-840f-c923e379e8fc">

    
4. 컨테이너 상태 확인:
    
    ```bash
    docker ps
    ```
    <img width="1757" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 52 36" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/1d0da9fc-fe1c-4706-9cb4-2f4c29bbf1e6">

    
여기서 출력된 컨테이너 목록에 **`0.0.0.0:8080->8080/tcp`**와 같은 항목이 포함되어 있는지 확인한다. 이 항목이 보인다면 Docker 컨테이너가 올바르게 포트를 매핑하고 있는 것!

1. 브라우저에서 확인:
    
    브라우저를 열고 **`http://localhost:8080/hello`**에 접속해서 "Hello World" 메시지가 잘 출력되는지 확인해보기
    <img width="967" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-05-14_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_2 52 54" src="https://github.com/Mingguriguri/-AdvWeb-BE_SpringStudy/assets/101111603/9ba64a74-7285-4b9f-a178-14a3f5560f6b">

    
    **잘 나오는 것을 확인할 수 있다!!!**
    
    이렇게 `EXPOSE 8080`을 추가해야 한다는 것을 알게 되었다.
