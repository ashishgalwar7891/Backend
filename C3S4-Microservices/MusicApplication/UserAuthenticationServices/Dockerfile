FROM openjdk:11-jre-slim
WORKDIR usr/src
ADD ./target/UserAuthenticationServices-0.0.1-SNAPSHOT.jar /usr/src/UserAuthenticationServices-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthenticationServices-0.0.1-SNAPSHOT.jar"]
