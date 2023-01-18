FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /appPatient

# Copy the JAR file into the container
COPY target/*.jar ./app-patient.jar

# Expose the application's port
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "app-patient.jar"]
