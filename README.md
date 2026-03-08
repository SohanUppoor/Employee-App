# Employee Management Application

## Overview

This project is a **full-stack Employee Management Application** built using:

* React (Frontend)
* Spring Boot (Backend)
* MySQL Database (AWS RDS)

The application allows users to **create, view employee records** through a web interface.

The backend APIs are deployed on AWS EC2 instances and the database is hosted on **AWS RDS**.

---

## Tech Stack

### Frontend

* React
* JavaScript
* Axios
* HTML / CSS

### Backend

* Spring Boot
* Java
* REST APIs
* Maven

### Database

* MySQL
* AWS RDS

### DevOps

* GitHub Actions (CI/CD)
* Terraform (Infrastructure provisioning)
* AWS EC2
* AWS ALB
* AWS S3 (artifact storage)

---

## Application Features

* Add new employees
* View employee list
* REST API integration between frontend and backend
* Database persistence using MySQL

---

## Application Architecture

User → React Frontend → Spring Boot API → MySQL (RDS)

### Flow

1. User accesses the application via browser.
2. React frontend sends API requests to Spring Boot backend.
3. Backend processes requests and interacts with the MySQL database.
4. Data is returned to the frontend and displayed to the user.

---

## Project Structure

```
employee-app/
│
├── backend/
│   ├── src/main/java
│   ├── src/main/resources
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
└── README.md
```

---

## Database Configuration

The backend connects to a **MySQL database hosted on AWS RDS**.

Example configuration in `application.properties`:

```
spring.datasource.url=jdbc:mysql://<rds-endpoint>:3306/employeeapp
spring.datasource.username=<username>
spring.datasource.password=<password>

spring.jpa.hibernate.ddl-auto=update
```

---

## CI/CD Pipeline

CI/CD is implemented using **GitHub Actions**.

Pipeline workflow:

1. Developer pushes code to GitHub
2. GitHub Actions builds the application
3. Frontend is built and copied to Spring Boot static directory
4. Backend JAR is generated
5. Artifact is uploaded to S3
6. EC2 instances download and run the application

---

## Deployment Architecture

Application is deployed using AWS infrastructure created with Terraform.

Components include:

* Application Load Balancer
* Auto Scaling Group
* EC2 instances running the application
* RDS MySQL database

The ALB distributes incoming traffic to EC2 instances running the Spring Boot application.

---

## Running Locally

### Backend

```
cd backend
mvn spring-boot:run
```

### Frontend

```
cd frontend
npm install
npm start
```

## API Example

Get all employees

```
GET /api/employees
```

Create employee

```
POST /api/employees
```

## Future Improvements

Potential enhancements include:

* Docker containerization
* Monitoring with CloudWatch

---

## Author

Developed as part of a **Cloud / DevOps portfolio project** demonstrating full-stack application development with automated CI/CD deployment to AWS.
