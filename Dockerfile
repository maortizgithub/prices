FROM openjdk:15-jdk-alpine
EXPOSE 9999
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN chmod 755 /app/mvnw

RUN ./mvnw package
ENTRYPOINT ["java","-jar","target/prices-0.0.1-SNAPSHOT.jar"]