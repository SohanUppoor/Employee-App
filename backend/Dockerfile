# -------- Stage 1: Build --------
FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml first (for caching dependencies)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests


# -------- Stage 2: Run --------
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose port
EXPOSE 8081

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]