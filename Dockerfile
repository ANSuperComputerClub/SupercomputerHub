FROM gradle:7.5.1-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM ghcr.io/graalvm/jdk:java17-21.3.0

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/SupercomputerHub-0.0.1-SNAPSHOT.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
