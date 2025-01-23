FROM eclipse-temurin:2323232323232323232323232323232323232323232323-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY build/libs/cardatabase-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
