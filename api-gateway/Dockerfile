FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /api-gateway

# Copy the JAR file into the container
COPY target/*.jar app-api.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app-api.jar"]
