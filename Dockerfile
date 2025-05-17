FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/ms-eventos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9081
ENTRYPOINT ["java", "-jar", "app.jar"]