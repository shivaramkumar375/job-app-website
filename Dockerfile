# Stage 1: Build the application with Maven
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the final, smaller image to run the application
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copy the built JAR file from the 'build' stage
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar
# Expose the port your Spring Boot app runs on (usually 8080)
EXPOSE 8080
# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]