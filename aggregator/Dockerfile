FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/aggregator-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} aggregator.jar

ENTRYPOINT ["java","-jar","/aggregator.jar"]