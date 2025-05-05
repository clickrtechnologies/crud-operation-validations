# CRUD Operation with Validations - Spring Boot Project

This project is a Spring Boot-based RESTful API that provides complete **CRUD (Create, Read, Update, Delete)** functionality along with proper **input validations** for managing entities (e.g., users, products, etc.).

---

## 📌 Features

- Spring Boot 3.x
- RESTful API with standard CRUD endpoints
- Input validation using Jakarta Bean Validation (e.g., @NotNull, @Email, @Size)
- Global exception handling
- JSON responses
- Maven project structure

---

## 🚀 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate Validator
- MySQL
- Maven

---

## 🧾 Database Table (Example: `users`)

```sql
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    phone VARCHAR(15),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
🧠 Validation Rules
name: required, 3–100 characters

email: required, valid format, unique

phone: optional, max 15 characters

📡 REST API Endpoints & CURL Commands
➕ Create User
Endpoint: POST /users

bash


curl -X POST http://localhost:8080/users \
-H "Content-Type: application/json" \
-d '{
  "name": "Raj Kumar",
  "email": "raj@example.com",
  "phone": "9876543210"
}'
📄 Get All Users
Endpoint: GET /users

bash


curl -X GET http://localhost:8080/users
🔍 Get User by ID
Endpoint: GET /users/{id}

bash


curl -X GET http://localhost:8080/users/1
✏️ Update User
Endpoint: PUT /users/{id}

bash


curl -X PUT http://localhost:8080/users/1 \
-H "Content-Type: application/json" \
-d '{
  "name": "Raj Updated",
  "email": "updated@example.com",
  "phone": "9999999999"
}'
❌ Delete User
Endpoint: DELETE /users/{id}

bash


curl -X DELETE http://localhost:8080/users/1
⚙️ How to Run
Clone the repository:

bash


git clone https://github.com/clickrtechnologies/crud-operation-validations.git
cd crud-operation-validations
Update application.properties with your DB credentials:

properties


spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build the project:

bash


mvn clean package
Run the application:

bash


java -jar target/ConsiderData.jar
🔐 Authentication
(Optional section – Add this if using Basic Auth, JWT, etc.)

🧑‍💻 Author
Raj Kumar
Software Engineer, Baseline IT Development, Mohali
GitHub Profile
