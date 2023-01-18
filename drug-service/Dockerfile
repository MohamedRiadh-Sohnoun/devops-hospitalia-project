FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /appDrug

# Copy the JAR file into the container
COPY target/*.jar ./app-drug.jar

# Expose the application's port
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "app-drug.jar"]
