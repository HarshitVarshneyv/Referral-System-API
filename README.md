# Referral System API
## 🚀 Problem Statement given by Simplify Money For Software engineering inter[Great thanks for selecting me and shotlisting me for this opportunity]

*********************** Java Backend LLM Assessment ***********************
Successful Referral
==============================================================
Problem Description
Create an API for user signup with referral code tracking, where a referral is
considered successful only after the user completes their profile.
For instance, if user A signs up using referral code of user B then successful
referral is considered only after user A completes the profile.
Expected Output -
1. User Signup Endpoint
-Allow signup with/without referral code
-Generate unique referral code for each user
-Validate referral code if provided
2. Referral Tracking
-Track referral status
-Link referrer and referred user
-Mark referral as complete upon profile completion
3. API Endpoints
-Signup API
-Profile Completion API
-Get Referrals API
-Referral Report API (Bonus)
Deployment Notes
-Deploy on a public server
-Share the GitHub repo
-Share the curl request
-Feel free to pick your choice of tools like NoSQL or SQL DB, choice of cloud
provider etc

Coding Guidelines
-Write clean, readable code
-Add meaningful comments
-Create comprehensive README
-Implement unit test cases
Brownie Points:
- An endpoint


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

