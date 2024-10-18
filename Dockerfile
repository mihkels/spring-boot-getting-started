# Stage 1: Build the application
FROM openjdk:21-jdk-slim AS build

WORKDIR /app
COPY . .
RUN ./gradlew clean build
RUN mv build/libs/*-SNAPSHOT.jar /app/build/libs/app.jar

# Stage 2: Run the application
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/build/libs/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]