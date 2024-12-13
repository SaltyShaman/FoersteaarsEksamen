# Project Name: First-Year Exam Project
## Description
This project is a web-based application designed to manage clients, employees, projects, subprojects, and calculators for project management. It is built using Spring Boot, Thymeleaf, and MySQL to provide CRUD functionality for various entities.
## Features
- Manage clients, employees, and projects.
- Assign tasks to employees and track progress.
- Create and manage subprojects and calculators.
- Generate and view reports for projects and employees.
- CRUD operations with a relational database.
## Technology Stack
- **Backend**: Java, Spring Boot
- **Frontend**: Thymeleaf, Bootstrap
- **Database**: MySQL
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
## Installation and Setup

### Prerequisites
- Java 17+
- Maven
- MySQL
- IntelliJ IDEA or any Java IDE

### Runs on 
http://localhost:8080.

## Usage 
- Find client and project
- Combine them into a calculator
- Assign tasks to the employees
- Assign employees to the subprojects
- (optional) assign employees to projects. In case you want to add employee task to the project without 
them being part of the subproject.

## Folder Structure

### Main
#### Java
- models
- controllers
- services
- repositories
#### Resources
- templates
- static
- application.properties



## Database Schema
### ER Diagram
(Include your ER diagram image here)
### Tables

1. **Calculator Employee Table**
   - `calculator_employee_id` int NOT NULL AUTO_INCREMENT (Primary key)
   - `calculator_table_id` int NOT NULL (Foreign key)
   - `employee_name` varchar(255) NOT NULL
   - `work_area` varchar(255) NOT NULL
   - `task` varchar(255) NOT NULL
   - `estimated_work_hours_per_employee` varchar(10) NOT NULL


2. **Calculator Table**
   - `calculator_table_id` int NOT NULL AUTO_INCREMENT (Calculator key)
   - `calculator_name` varchar(50) DEFAULT NULL
   - `client_id` bigint NOT NULL (Foreign key)
   - `project_management_id` int NOT NULL (Foreign key)


3. **Client Table**
   - `client_id` bigint NOT NULL AUTO_INCREMENT (Primary key)
   - `client_company` varchar(255) NOT NULL
   - `client_email` varchar(255) NOT NULL
   - `client_name` varchar(255) NOT NULL


4. **Employee Subprojects Table**
   - `employee_id` int NOT NULL (Primary key)
   - `subproject_id` int NOT NULL (Primary key)
 

5. **Employee Table**
   - `employee_id` int NOT NULL AUTO_INCREMENT (Primary key)
   - `employee_name` varchar(255) NOT NULL
   - `calculator_table_id` int DEFAULT NULL (Foreign key)
  

6. **Employeetasks Table**
   - `employee_id` int NOT NULL (Primary key)
   - `tasks_id` int NOT NULL (Primary key)
   

7. **Project Management Table**
   - `project_management_Id` int NOT NULL AUTO_INCREMENT (Primary key)
   - `project_name` varchar(255) NOT NULL (Unique key)
   - `project_leader` varchar(255) NOT NULL


8. **Subprojects Table**
   - `subproject_id` int NOT NULL AUTO_INCREMENT (primary key)
   - `subproject_name` varchar(255) NOT NULL
   - `project_management_id` int NOT NULL (Foreign key)


9. **Task Table**
   - `tasks_id` int NOT NULL AUTO_INCREMENT (Primary key)
   - `task_name` varchar(255) NOT NULL
   - `estimated_work_hours_per_task` int NOT NULL


## Contributors
- [Lukas Bergstein Turner](https://github.com/LukasBalthazar) - Developer
- [Kristoffer Søholm Gillesberg](https://github.com/SaltyShaman) - Developer

## Future Enhancements
- Implement detailed analytics and reporting tools.
- Add authentication and role-based access control.
- Enhance the UI/UX with modern frameworks like React or Angular.





