# Build stage
FROM maven:latest AS build-stage
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn package

# Runtime stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build-stage /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]