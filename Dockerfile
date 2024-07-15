FROM openjdk:23-ea-22-jdk-slim

EXPOSE 8081

ADD target/SpringBoot_Profile-0.0.1-SNAPSHOT.jar profileApp.jar

ENTRYPOINT ["java", "-jar", "profileApp.jar"]