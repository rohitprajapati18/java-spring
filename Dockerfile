FROM openjdk:8-jdk-alpine
COPY target/practice-0.0.1-SNAPSHOT.jar practice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/practice-0.0.1-SNAPSHOT.jar"]