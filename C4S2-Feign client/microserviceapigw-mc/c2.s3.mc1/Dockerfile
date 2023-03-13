FROM openjdk
WORKDIR usr/lib
ADD /target/c2.s3.mc1-0.0.1-SNAPSHOT.jar tracks.jar
ENTRYPOINT ["java","-jar","tracks.jar"]