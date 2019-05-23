FROM openjdk:11-slim
WORKDIR .
COPY build/libs/helloworld-1.0-SNAPSHOT.jar .
EXPOSE 80
CMD ["java", "-jar", "helloworld-1.0-SNAPSHOT.jar"]