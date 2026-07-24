FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw && ./mvnw clean package -DskipTests

ENTRYPOINT ["java","-jar","target/flower-dashboard-0.0.1-SNAPSHOT.jar"]