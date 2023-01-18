FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /appointment-service

# Copy the JAR file into the container
COPY target/*.jar app-appointment.jar

# Expose the application's port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app-appointment.jar"]
