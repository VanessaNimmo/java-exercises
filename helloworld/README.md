# Hello World Server

When running this server has the following endpoints:

### '/'

Returns a greeting to Vanessa and the time on the server (AEST).

### '/names'

Responds to GET, POST, PUT and DELETE in the standard HTTP manner.

## Running the App Locally Manually

The project uses gradle with a wrapper. To build the project, use:

```./gradlew build```

To run unit tests, use:

```./gradlew test```

And for integration tests, use:

```./gradlew integrationTest```

To run the app, run the following after building:

```java -jar build/libs/helloworld-1.0-SNAPSHOT.jar```

## Running the App Locally with Docker

To build a production docker image, run 
```
docker build -t helloworld -f Dockerfile.app .
```

To run the file:
```
docker run -P -p 80:8080 helloworld
```

Use ```docker ps``` to see a list of running images and ```docker port <container-name>``` to find out the port to connect with the container.