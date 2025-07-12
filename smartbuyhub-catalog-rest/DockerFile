FROM openjdk:17-jdk-slim

WORKDIR /app

ADD target/smartbuyhub-catalog-rest-1.0.0-SNAPSHOT.jar /app/smartbuyhub-catalog-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "smartbuyhub-catalog-docker.jar"]
