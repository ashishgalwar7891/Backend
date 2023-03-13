FROM openjdk
WORKDIR usr/lib
ADD ./target/discovery-server-0.0.1-SNAPSHOT.jar /usr/lib/discovery-server-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","discovery-server-0.0.1-SNAPSHOT.jar"]