FROM gradle:8.7.0-jdk17 AS builder
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY gradlew /app/gradlew
COPY gradle /app/gradle/
RUN ./gradlew wrapper
COPY . /app
RUN ./gradlew build -x test --parallel

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /app/build/libs/cardatabase-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
