# Sử dụng phiên bản chính thức của Maven với OpenJDK 17
FROM maven:3.8.8-eclipse-temurin-17 AS build

COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
