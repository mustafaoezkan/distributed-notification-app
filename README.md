# Distributed Notification App

The **Distributed Notification App** is a Spring Boot application integrated with RabbitMQ and MySQL. It provides a notification management system, enabling prioritized and persistent notification processing while supporting multiple delivery channels.

---

## Features

1. **RabbitMQ Integration**:
   - Queue-based message processing.
   - Support for multiple listeners.
2. **MySQL Persistence**:
   - Save notifications for tracking and auditing.
3. **Priority-Based Notifications**:
   - Handle high, medium, and low-priority notifications.
4. **Multiple Delivery Channels**:
   - Mobile devices.
   - Database logging.
5. **Containerized with Docker**:
   - Fully functional via Docker Compose.

---

## Architecture

1. **RabbitMQ**:
   - Acts as the message broker for notification distribution.
   - Supports different exchange types for message routing.
2. **Spring Boot**:
   - Processes notifications with multiple consumers.
   - Saves notifications to MySQL database.
3. **MySQL**:
   - Stores notification data persistently for auditing and reporting.

---

## Prerequisites

1. Docker and Docker Compose installed.
2. Java 17 or higher installed locally.
3. Maven installed for local development.

---

## Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/mustafaoezkan/distributed-notification-app.git
cd distributed-notification-app
```

### 2. Environment Configuration

Create a `.env` file in the project root:

```env
# MySQL Configuration
MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=notifier
MYSQL_USER=root
MYSQL_PASSWORD=root

# Spring App Configuration
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
```

### 3. Docker Compose

Build and run the application with Docker Compose:

```bash
docker compose up --build
```

### 4. RabbitMQ Management Console

Access RabbitMQ management UI at:

- URL: [http://localhost:15672](http://localhost:15672)
- Username: `guest`
- Password: `guest`

### 5. MySQL Database

Access MySQL using your preferred client:

- Host: `localhost`
- Port: `3307`
- Database: `notifier`
- Username: `root`
- Password: `root`

### 6. Test the Application

Use Postman or `curl` to send a test notification:

```bash
curl -X POST \
     -H "Content-Type: application/json" \
     -d '{"title": "Test Title", "message":"Test Notification","recipient":"user@example.com","priority":"HIGH"}' \
     http://localhost:8080/api/notifications
```

---

## Project Structure

```
distributed-notification-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com.example.distributednotificationapp/
│   │   │   │   ├── config/     # RabbitMQ configuration
│   │   │   │   ├── controller/ # REST controllers
│   │   │   │   ├── entity/     # JPA entities
│   │   │   │   ├── repository/ # JPA repositories
│   │   │   │   ├── service/    # Service classes
│   │   │   │   └── model/      # Models for message payloads
│   ├── resources/
│   │   ├── application.properties  # Spring configuration
├── Dockerfile
├── docker-compose.yml
├── README.md
└── .env
```

---

## Key Endpoints

### **POST /api/notifications**

Create a new notification.

#### Request Body:

```json
{
  "title": "Test tilte",
  "message": "Your notification message",
  "recipient": "user@example.com",
  "priority": "HIGH"
}
```

### **GET /api/admin/notifications**

Retrieve all notifications stored in the database.

---

---

## Future Enhancements

1. **Retry Mechanism**:
   - Add a dead-letter queue for failed notifications.
2. **Push Notification Support**:
   - Extend to support real-time WebSocket notifications.
3. **Admin Dashboard**:
   - Create a front-end for monitoring notifications.

---

## License

This project is licensed under the MIT License. See the LICENSE file for details.

