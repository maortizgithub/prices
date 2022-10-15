# Prices API

## Foreword
This basic Prices API was developed as a technical test.

## Technical Stack
The App is developed by using the Spring Framework base dependencies to manage code.
Libraries included:
- **Spring Boot Starter Web**: for providing basic application layout.
- **Spring Boot JPA**: for providing basic application layout.
- **mapstruct**: Java utilities for mapping objects.
- **Lombok**: Java utilities for speeding up development and enforce clean code.
- **H2 DB**: A local database.
- **Cucumber**: for ATDD test with Gherkin language.
- **Rest assured**: Calling API in easy way.
- **JUnit**: used for running Application Unit Tests

In order to build this app to be run in a production environment, first compile it:
```
    mvn clean install
```
This command will generate a JAR file that could be deployed in whatever environment you decide (assuming it has a JVM).

## SpringBoot Run Application
This is a spring-boot application managed by maven.
To run it locally, just cmd to your app directory and run the following command:
```
    mvn spring-boot:run
```
## Docker run Application
To run it in a docker, just cmd to your app directory and run the following commands:
```
    docker build -t prices .
    docker run --rm -it -p 9999:9999 -t prices
```

## Access Application by Postman (port 9999)
```
    http://localhost:9999/prices
```
## Technical Decisions

- I have tried to follow a **hexagonal architecture** design, that will help us decouple the different layers on an application.
- Nowadays, this architecture is becoming a trend on microservices development because makes it easier to adapt applications to changes.

## OTHER NOTES

- PriceDTO has the fields that TestJava2022 indicates. currency and priority has been removed because this.
  (Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.)
