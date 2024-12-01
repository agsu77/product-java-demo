# Build stage
FROM openjdk:17-jdk-alpine AS build-stage
WORKDIR /app
COPY src /app/src
COPY pom.xml /app/pom.xml
RUN mvn package

# Runtime stage
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build-stage target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]