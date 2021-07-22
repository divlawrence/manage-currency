FROM openjdk:11-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} manage-currency.jar

CMD exec java -jar /manage-currency.jar
