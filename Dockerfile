# Use a Maven image to build the application
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Set the working directory inside the builder
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application and create the JAR file
RUN mvn clean package -DskipTests

# Use a lightweight Java image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the runtime container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
