# Use the official Maven image as the build environment
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file to the container
COPY pom.xml .

# Download the project dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code to the container
COPY src ./src

# Build the application JAR file
RUN mvn package -DskipTests

# Use the official MySQL Server image as the base image for the runtime environment
FROM mysql:8.0

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file from the build environment to the container
COPY --from=build /app/target/book_my_show-0.0.1-SNAPSHOT.jar .

# Set the root password for MySQL Server
ENV MYSQL_ROOT_PASSWORD=my-secret-password

# Use the adoptopenjdk image as the base image for Java runtime
FROM openjdk:17-jdk-slim-buster

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file from the previous stage
COPY --from=0 /app/book_my_show-0.0.1-SNAPSHOT.jar .

# Expose the default Spring Boot port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "book_my_show-0.0.1-SNAPSHOT.jar"]
