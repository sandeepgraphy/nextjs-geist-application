# Urban Companion Backend

A **Spring Boot** REST API for a non-sexual male-companion booking platform in **Hyderabad**.

---

## ⚖️ Legal & Ethical Notice
- **Services are strictly non-sexual.**
- This is a **concept/demo project** only.
- All activities must comply with local laws.

---

## 🚀 Quick Start

### 1. Prerequisites
- Java 17+
- Maven 3.9+
- Docker & Docker Compose (for MySQL + MongoDB)

### 2. Start Databases
```bash
docker-compose up -d
```

### 3. Run the App
```bash
mvn spring-boot:run
```
Server starts on `http://localhost:8080`

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/users/register` | Register new user |
| POST | `/api/users/login` | Login & receive JWT |
| GET | `/api/companions?location=Hyderabad` | List available companions |
| GET | `/api/companions/{id}` | Get companion profile |
| POST | `/api/bookings` | Book a session |
| GET | `/api/bookings/history?userId=1` | View past bookings |

---

## 🔐 Authentication
Include the JWT in the `Authorization` header:
```
Bearer <token>
```

---

## 🧪 Sample Mongo Seed (optional)
```json
db.companion_profiles.insertOne({
  "name": "Ravi",
  "age": 25,
  "location": "Hyderabad",
  "languages": ["Hindi", "English", "Telugu"],
  "profilePhoto": "/uploads/ravi.jpg",
  "about": "Friendly and talkative. Loves parties.",
  "ratings": 4.6,
  "available": true
})
```

---

## 🛠️ Configuration
Edit `application.yml` to change DB credentials, JWT secret, or service fee.

---

Happy coding!
