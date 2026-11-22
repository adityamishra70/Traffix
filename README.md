# Traffix 🚦
### Distributed API Management, Smart Gateway & Analytics Platform

Traffix is a distributed API management platform designed to provide centralized API configuration, intelligent request routing, traffic control, and API traffic analytics.

The platform consists of three primary services:

- **API Management Service** – Manages API routes, gateway configurations, and administrative operations.
- **Smart Gateway Service** – Processes incoming client requests, applies configured policies, and forwards requests to backend services.
- **Analytics Service** – Handles gateway traffic analytics, enabling centralized monitoring and analysis of API activity.

The services communicate through event-driven architecture using Apache Kafka, enabling asynchronous communication and runtime configuration synchronization.

> **Project Status:** Under Active Development

---

## 🏗️ Architecture

```text
                         CLIENT
                            |
                            v
                  +-------------------+
                  |   Smart Gateway   |
                  +-------------------+
                            |
             +--------------+--------------+
             |              |              |
             v              v              v
          Routing       Rate Limit     Idempotency
             |              |              |
             +--------------+--------------+
                            |
                            v
                    BACKEND SERVICES
                            |
                            |
                 Gateway Traffic Events
                            |
                            v
                    +---------------+
                    |     Kafka     |
                    +---------------+
                            |
                            v
                    +-------------------+
                    | Analytics Service|
                    +-------------------+
                            |
                            v
                    Traffic Analytics
                    and Insights


       +----------------------------+
       |    API Management Service  |
       |                            |
       | Route Management           |
       | Gateway Configuration      |
       | Administrative Operations  |
       +----------------------------+
                    |
                    | Configuration Events
                    v
               +----------+
               |  Kafka   |
               +----------+
                    |
                    v
             Smart Gateway
             Configuration
                  Consumer
                    |
                    v
             Runtime Configuration
                   Updates
```

### Core Services

| Service | Responsibility |
|---|---|
| API Management | Centralized API and gateway configuration |
| Smart Gateway | Request routing, policy enforcement, and traffic handling |
| Analytics | Gateway traffic analytics and monitoring |

---

## ✨ Key Features

### 1. API Management
- Centralized API route management.
- Gateway configuration management.
- Administrative operations.
- Configurable allowed HTTP methods.
- Runtime configuration synchronization.

### 2. Smart API Gateway
- Dynamic route matching.
- HTTP method validation.
- Request forwarding to backend services.
- Configurable rate limiting.
- Idempotency support.
- Correlation ID generation.
- Standardized error responses.

### 3. Analytics Service
- Gateway traffic event processing.
- API request analytics.
- Traffic monitoring.
- Centralized analytics processing.

### 4. Event-Driven Communication
- Apache Kafka integration.
- Asynchronous configuration propagation.
- Gateway configuration event consumption.
- Gateway traffic event processing.

### 5. Redis Integration
- Rate-limit counters.
- Idempotency records.
- Shared state for distributed gateway operations.

---

## 🔄 Configuration Synchronization

```text
API Management Service
          |
          v
Configuration Updated
          |
          v
Publish Kafka Event
          |
          v
gateway-configuration-events
          |
          v
Smart Gateway Consumer
          |
          v
Update Runtime Configuration
```

Configuration changes can be propagated to the gateway without requiring service restarts.

---

## 📊 Analytics Processing

The Analytics Service is a separate component of Traffix. It is intended to process gateway traffic information independently of the request-processing path.

```text
Client Request
      |
      v
Smart Gateway
      |
      v
Gateway Traffic Event
      |
      v
    Kafka
      |
      v
Analytics Service
      |
      v
Traffic Analytics
```

This separation allows analytics processing to remain independent of the gateway's primary responsibility of handling client requests.

---

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend development |
| Spring Boot | Application framework |
| Spring Security | Authentication and authorization |
| JWT | Token-based authentication |
| Spring Data JPA / Hibernate | Persistence |
| MySQL | Relational database |
| Apache Kafka | Event-driven communication |
| Redis | Rate limiting and shared data |
| Maven | Build and dependency management |
| Docker | Containerization |

---

## 📁 Project Structure

```text
traffix/
│
├── api-management-service/
│   ├── src/
│   └── pom.xml
│
├── smart-gateway-service/
│   ├── src/
│   └── pom.xml
│
├── analytics-service/
│   ├── src/
│   └── pom.xml
│
├── docker-compose.yml
│
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- Maven
- Docker Desktop
- MySQL
- Apache Kafka
- Redis

### Clone the repository

```bash
git clone <YOUR_REPOSITORY_URL>
cd traffix
```

### Start infrastructure

```bash
docker compose up -d
```

### Build the services

Build each Spring Boot service using Maven:

```bash
mvn clean install
```

Configure the database, Kafka, Redis, and application properties before starting the services.

---

## 🔮 Future Enhancements

- Circuit breaker and retry mechanisms.
- Advanced traffic analytics and dashboards.
- Request and response transformation.
- Distributed tracing.
- Centralized logging.
- Multi-instance gateway support.
- Advanced routing strategies.
- Gateway health monitoring.

---

## 🎯 Project Objective

Traffix explores the design and implementation of a distributed API management platform by combining API gateway functionality, centralized configuration management, event-driven communication, and independent analytics processing.

**Traffix — Manage APIs. Control Traffic. Understand Performance.**
