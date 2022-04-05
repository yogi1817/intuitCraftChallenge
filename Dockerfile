FROM openjdk:11
ARG JAR_FILE=target/challenge-1.0.jar
COPY ${JAR_FILE} challenge-1.0.jar
ENTRYPOINT ["java","-jar","/challenge-1.0.jar"]
