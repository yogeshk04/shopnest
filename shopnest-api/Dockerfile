# Stage 1: Build Stage

# Use the official maven/Java 8 image to create a build artifact.
FROM maven:3.8.5-openjdk-17-slim AS build

# Set working directory
WORKDIR /app

# Copy the POM file
COPY pom.xml .
# Copy the rest of the application code
COPY src /app/src
# Build the application
RUN mvn -DskipTests clean package

# Stage 2: Run Stage

# Use AdoptOpenJDK for the base image
FROM openjdk:17.0-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/shopnest-api*.jar /app/app.jar

# Expose the port
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "-jar", "/app/app.jar"]
