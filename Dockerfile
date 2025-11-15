FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/patient-devops-app-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]