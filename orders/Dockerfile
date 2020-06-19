FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=target/orders-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} orders.jar

ENTRYPOINT ["java","-jar","/orders.jar"]