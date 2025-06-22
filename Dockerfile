#Existing Jetty WAR-Based Setup
#----------------

#FROM eclipse-temurin:17-jre-alpine

#WORKDIR /swagger-petstore

#COPY target/lib/jetty-runner.jar /swagger-petstore/jetty-runner.jar
#COPY target/*.war /swagger-petstore/server.war
#COPY src/main/resources/openapi.yaml /swagger-petstore/openapi.yaml
#COPY inflector.yaml /swagger-petstore/

#EXPOSE 8080

#CMD ["java", "-jar", "-DswaggerUrl=openapi.yaml", "/swagger-petstore/jetty-runner.jar", "--log", "/var/log/yyyy_mm_dd-requests.log", "/swagger-petstore/server.war"]


# Use a JDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy built Spring Boot JAR
COPY target/swagger-petstore*.jar app.jar

# Expose port 8080 for API access
EXPOSE 8080

# Start the app
ENTRYPOINT ["java", "-jar", "app.jar"]
