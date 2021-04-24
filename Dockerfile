FROM amazoncorretto:11-alpine-jdk

WORKDIR /app
COPY target/qa-training-*.jar application.jar

CMD ["java", "-jar", "/app/application.jar"]
