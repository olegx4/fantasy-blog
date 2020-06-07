FROM gradle:6.2.1-jdk11 as builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-slim
RUN mkdir /app
COPY --from=builder /home/gradle/src/build/libs/fantasy-blog-0.0.1-SNAPSHOT.jar /app/springapp.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/springapp.jar"]