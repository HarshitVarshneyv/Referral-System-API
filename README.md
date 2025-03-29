# Referral System API

## 🚀 Overview
The **Referral System API** is a backend service built using **Spring Boot** and **JPA** that allows users to sign up using referral codes and track their successful referrals. The system considers a referral "successful" only when the referred user completes their profile.

## 🏗 Tech Stack
- **Java 17 / 21**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL** (or H2 for testing)
- **Lombok**
- **Postman** (for API testing)

## 📌 Features
- ✅ **User Registration with Referral Code**
- ✅ **Check Successful Referrals**
- ✅ **Get Referral Report**
- ✅ **RESTful API Design**
- ✅ **Spring Data JPA Integration**

## 🛠 Installation & Setup
### 1️⃣ Clone the Repository
```bash
git clone https://github.com/yourusername/referral-system.git
cd referral-system
```

### 2️⃣ Configure Database
Modify `application.properties` in `src/main/resources/`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/referral_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```

## 🌍 API Endpoints
### 1️⃣ **User Signup**
📌 `POST /api/users/signup`
#### Request Body:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "12345",
  "referralCode": "abc123"
}
```
#### Response:
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "referralCode": "abc123",
  "profileCompleted": false
}
```

### 2️⃣ **Complete User Profile**
📌 `PUT /api/users/{userId}/complete-profile`
#### Response:
```json
{
  "message": "Profile completed successfully"
}
```

### 3️⃣ **Check Referrals**
📌 `GET /api/users/{userId}/referrals`
#### Response:
```json
[
  {
    "id": 2,
    "name": "Jane Doe",
    "email": "jane@example.com",
    "referralCode": "xyz789",
    "profileCompleted": true
  }
]
```

### 4️⃣ **Get Referral Report**
📌 `GET /api/users/referral-report`
#### Response:
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "referralCode": "abc123",
    "successfulReferrals": 1
  }
]
```

## 🎯 Project Structure
```
referral-system/
├── src/main/java/com/backendllm/project/
│   ├── controller/UserController.java
│   ├── entity/User.java
│   ├── repository/UserRepository.java
│   ├── service/UserService.java
│   ├── dto/ReferralReportDTO.java
├── src/main/resources/application.properties
├── pom.xml
└── README.md
```

## 📝 Contributing
Contributions are welcome! To contribute:
1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature-name`)
3. **Commit your changes** (`git commit -m "Added new feature"`)
4. **Push to GitHub** (`git push origin feature-name`)
5. **Submit a Pull Request**

## 📄 License
This project is licensed under the **MIT License**.

---
🚀 **Happy Coding!**

