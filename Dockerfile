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

# Use the official OpenJDK 17 image as the base image for the runtime environment
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file from the build environment to the container
COPY --from=build /app/target/my-spring-boot-app.jar .

# Install MySQL Server
RUN apt-get update && apt-get install -y mysql-server

# Configure MySQL
RUN service mysql start && mysql -u root -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root'; FLUSH PRIVILEGES;"

# Expose the default Spring Boot port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "my-spring-boot-app.jar"]
