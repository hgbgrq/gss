FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gss-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gss-0.0.1-SNAPSHOT.jar"]