FROM eclipse-temurin:21-jdk

LABEL authors="nikhil"

WORKDIR /app

COPY ./target/*.jar /app

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]