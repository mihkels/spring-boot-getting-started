# Stage 1: Build the application
FROM eclipse-temurin:27-jdk AS build

WORKDIR /app
COPY gradlew settings.gradle.kts build.gradle.kts ./
COPY gradle gradle
COPY src src
RUN ./gradlew clean build
RUN mv build/libs/*-SNAPSHOT.jar /app/build/libs/app.jar

# Stage 2: Run the application
FROM eclipse-temurin:27-jre
WORKDIR /app
COPY --from=build /app/build/libs/app.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]