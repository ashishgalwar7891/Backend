FROM openjdk
WORKDIR usr/lib
ADD /target/apigw-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java","-jar","gateway.jar"]