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

# Environment variables (will be overridden in ECS)
ENV DB_URL=jdbc:mysql://employee-db.ck1g4kukuf65.us-east-1.rds.amazonaws.com:3306/employeedb
ENV DB_USERNAME=admin
ENV DB_PASSWORD=Employee123

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]