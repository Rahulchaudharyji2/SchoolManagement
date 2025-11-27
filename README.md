# School Management System

A robust backend for a School Management System built with Java Spring Boot, managing Students, Teachers, Courses, and Enrollments. It includes secure JWT authentication and Role-Based Access Control.

## 🚀 Technologies Used
*   **Java 17+**
*   **Spring Boot 3** (Web, Data JPA, Security)
*   **MySQL** (Database)
*   **Hibernate** (ORM)
*   **JWT (JSON Web Token)** (Authentication)
*   **SpringDoc OpenAPI** (Swagger UI for API Documentation)
*   **Maven** (Build Tool)

## 🛠️ Prerequisites
*   Java Development Kit (JDK) 17 or higher
*   Maven
*   MySQL Server

## ⚙️ Configuration
1.  **Database**: Create a MySQL database named `hibernate_demo`.
2.  **Properties**: Update `src/main/resources/application.properties` with your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/hibernate_demo
    spring.datasource.username=root
    spring.datasource.password=YourPassword
    ```
3.  **JWT Secret**: You can change the `app.jwt.secret` in `application.properties` to a secure random string.

## 🏃‍♂️ How to Run
1.  **Clone the repository**:
    ```bash
    git clone https://github.com/Rahulchaudharyji2/SchoolManagement.git
    cd SchoolManagement
    ```
2.  **Build the project**:
    ```bash
    mvn clean install
    ```
3.  **Run the application**:
    ```bash
    mvn spring-boot:run
    ```
    The server will start on `http://localhost:8080`.

## 📖 API Documentation (Swagger UI)
Once the application is running, you can access the interactive API documentation to test all endpoints:
👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

## 🔌 API Endpoints

### Authentication
*   `POST /api/auth/signup` - Register a new user (Admin/User)
*   `POST /api/auth/login` - Login and receive a JWT Token

### Students
*   `POST /api/students` - Create a new Student
*   `GET /api/students` - Get all Students
*   `GET /api/students/{id}` - Get Student by ID
*   `PUT /api/students/{id}` - Update Student
*   `DELETE /api/students/{id}` - Delete Student

### Courses
*   `POST /api/courses` - Create a new Course
*   `GET /api/courses` - Get all Courses
*   `GET /api/courses/{id}` - Get Course by ID
*   `DELETE /api/courses/{id}` - Delete Course

### Teachers
*   `POST /api/teachers` - Create a new Teacher
*   `GET /api/teachers` - Get all Teachers

### Enrollments
*   `POST /api/enrollments` - Enroll a Student in a Course

## 🔐 Security & Testing
*   **Protected Routes**: Most endpoints (except Auth and Swagger) require a JWT Token.
*   **How to Authenticate**:
    1.  **Signup** a user.
    2.  **Login** to get the `token`.
    3.  Add the token to the **Authorization** header in your requests:
        *   Key: `Authorization`
        *   Value: `Bearer <your_token_here>`

## ⚠️ Troubleshooting
*   **403 Forbidden**: Ensure you are using a **valid, non-expired token**. If you restarted the server or changed the secret code, generate a NEW token by logging in again.
*   **Database Errors (Field 'id' doesn't have a default value)**: This happens if tables were created incorrectly. Set `spring.jpa.hibernate.ddl-auto=create` in `application.properties` and restart to reset the schema. (Warning: This wipes data).

## 🤝 Contributing
1.  Fork the repository
2.  Create a feature branch
3.  Commit your changes
4.  Push to the branch
5.  Open a Pull Request
