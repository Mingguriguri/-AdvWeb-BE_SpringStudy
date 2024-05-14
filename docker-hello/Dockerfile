#FROM ubuntu:latest
#LABEL authors="minjeong"
#
#ENTRYPOINT ["top", "-b"]
FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]