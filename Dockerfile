FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/to-do-list-api-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8000

ENTRYPOINT ["java","-jar","app.jar"]