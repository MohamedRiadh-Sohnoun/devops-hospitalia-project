FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /discovery-server

# Copy the JAR file into the container
COPY target/*.jar /discovery-server/app-discovery.jar

# Expose the application's port
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "app-discovery.jar"]
