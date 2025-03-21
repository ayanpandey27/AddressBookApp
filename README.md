# Address Book Application

## Overview
The **AddressBookApp** is a contact management system built using Java and Spring Boot. It allows users to efficiently manage contacts with CRUD operations, authentication, and role-based access control.

## Features
- **User Authentication**: Secure login and registration with JWT-based authentication.
- **Add Contacts**: Store names, phone numbers, email addresses, and more.
- **Edit Contacts**: Modify existing contact details.
- **Delete Contacts**: Remove unwanted contacts from the list.
- **Search & Filter**: Quickly locate contacts based on different attributes.
- **Role-Based Access Control**: Manage access based on user roles.
- **Database Integration**: Uses MySQL/PostgreSQL for data storage.
- **RESTful API**: Exposes endpoints for frontend or external integration.
- **Swagger API Documentation**: Provides detailed API documentation.

## Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Spring Security & JWT**
- **Spring Data JPA (Hibernate)**
- **MySQL/PostgreSQL**
- **Swagger (OpenAPI)**
- **Lombok**
- **Docker (Optional)**

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/ayanpandey27/AddressBookApp.git
   ```
2. Navigate to the project directory:
   ```bash
   cd AddressBookApp
   ```
3. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/addressbook
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Build and run the application:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
5. Access the API documentation at:
   ```
   http://localhost:8080/swagger-ui/
   ```

## Usage
- **Register/Login**: Authenticate users via JWT.
- **Manage Contacts**: Use API endpoints to add, edit, delete, and search contacts.
- **Admin Controls**: Grant or revoke user access.

## Future Enhancements
- **Cloud Deployment**: Deploy to AWS/GCP.
- **Microservices Architecture**: Separate authentication and contact management.
- **GraphQL Support**: Enable flexible queries.
- **Multi-Tenancy**: Support multiple users with isolated data.

## License
This project is open-source and available under the MIT License.

