# Volga - Terrace Reservation System for Community

## Project Overview

Volga is a simple backend system designed to manage reservations and visits for a shared terrace in a residential community.  
The main features include:

- **Reservation of terrace usage:** Colonos (residents) can book time slots with advance approval by an administrator.
- **Limit concurrent usage:** The terrace has a maximum capacity for concurrent visitors on regular days.
- **Private events on weekends:** On Saturdays and Sundays, colonos can reserve the terrace fully for private events, limited to two private event reservations per year per colono.
- **Visit tracking:** Records daily visits, with check-in and check-out to track active occupancy.
- **User roles:** Supports colonos and administrators. Administrators can be colonos or external users (managed via AWS Cognito).
- **Authentication:** Secure user authentication is managed with JWT tokens issued by AWS Cognito.

---

## Technology Stack

- **Backend:** Java 17 with Spring Boot (reactive stack using Spring WebFlux and R2DBC)
- **Database:** PostgreSQL hosted on AWS RDS
- **Infrastructure:** Local Kubernetes cluster for development (Docker Compose available for quick local testing)
- **Version Control:** Git and GitHub

---

## Database Design Highlights

- `users`: stores colonos and admins, linked to AWS Cognito user identities.
- `reservations`: holds terrace booking data, with flags for private events and date/time ranges.
- `visits`: tracks daily visitor entries and exits to enforce capacity limits.
- `reservation_status`: lookup table to manage statuses consistently (pending, approved, rejected, etc).

---

## Getting Started

### Prerequisites

- Docker and Docker Compose installed
- Kubernetes (optional for local cluster)
- Java 17+ and Gradle installed
- AWS account with configured RDS PostgreSQL instance
- AWS Cognito user pool for authentication

### Environment Variables

Create a `.env` file with the following variables:

```bash
POSTGRES_DB=your_db_name
POSTGRES_USER=your_db_user
POSTGRES_PASSWORD=your_db_password

SPRING_PROFILES_ACTIVE=dev

AWS_ACCESS_KEY_ID=your_access_key
AWS_SECRET_ACCESS_KEY=your_secret_key
AWS_REGION=your_aws_region
COGNITO_USER_POOL_ID=your_cognito_user_pool_id
COGNITO_CLIENT_ID=your_cognito_client_id
```
### Running Locally with Docker Compose
Build and start services:

```bash
docker-compose --env-file .env up --build
```
The backend will be accessible at: http://localhost:8080

Connect your backend to the AWS RDS PostgreSQL instance by setting correct database URL in your application.yml for profile dev.

Volga © 2025 - Community Terrace Management
