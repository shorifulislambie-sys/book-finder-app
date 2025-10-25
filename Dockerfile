# Build stage 
FROM maven:3.9-eclipse-temurin-17 AS build 
WORKDIR /app 
COPY pom.xml . 
RUN mvn dependency:go-offline 
COPY src ./src 
RUN mvn clean package -DskipTests 
 
# Runtime stage 
FROM eclipse-temurin:17-jre 
WORKDIR /app 
COPY --from=build /app/target/book-finder-1.0-SNAPSHOT.jar app.jar 
EXPOSE 8080 
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"] 
