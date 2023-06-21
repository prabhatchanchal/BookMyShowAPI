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
COPY --from=build /app/target/book_my_show-0.0.1-SNAPSHOT.jar .

# Install MySQL Server from official MySQL APT repository
RUN apt-get update && apt-get install -y gnupg
RUN apt-key adv --keyserver pgp.mit.edu --recv-keys 5072E1F5
RUN echo "deb http://repo.mysql.com/apt/debian/ buster mysql-8.0" > /etc/apt/sources.list.d/mysql.list
RUN apt-get update && apt-get install -y mysql-server

# Configure MySQL
RUN service mysql start && mysql -u root -e "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root'; FLUSH PRIVILEGES;"

# Expose the default Spring Boot port
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "book_my_show-0.0.1-SNAPSHOT.jar"]
