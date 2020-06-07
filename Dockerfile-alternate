FROM openjdk:11-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/fantasy-blog-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} springapp.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/springapp.jar"]