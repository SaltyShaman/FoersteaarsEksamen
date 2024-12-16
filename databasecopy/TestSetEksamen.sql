CREATE DATABASE IF NOT EXISTS foerste_aars_eksamen DEFAULT CHARACTER SET utf8;
USE foerste_aars_eksamen;

-- Drop tables and foreign key constraints
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS project_management;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS calculator_table;
DROP TABLE IF EXISTS employee_table;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS employee_tasks;
DROP TABLE IF EXISTS subprojects;
DROP TABLE IF EXISTS employee_subprojects;
SET FOREIGN_KEY_CHECKS = 1;

-- Create project_management table first, since it is referenced by other tables
CREATE TABLE project_management (
    project_management_Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL UNIQUE,
    project_leader VARCHAR(255) NOT NULL
);

-- Create client table
CREATE TABLE client(
    client_id BIGINT NOT NULL AUTO_INCREMENT, 
    client_company VARCHAR(255) NOT NULL,
    client_email VARCHAR(255) NOT NULL,
    client_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (client_id)
);

-- Create subprojects table, referencing project_management
CREATE TABLE subprojects (
    subproject_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    subproject_name VARCHAR(255) NOT NULL,
    project_management_id INTEGER NOT NULL,
    FOREIGN KEY (project_management_id) REFERENCES project_management(project_management_Id)
);

-- Create calculator_table, referencing client and project_management
CREATE TABLE calculator_table (
    calculator_table_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    calculator_name VARCHAR(50),
    client_id BIGINT NOT NULL,
    project_management_id INTEGER NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(client_id),
    FOREIGN KEY (project_management_id) REFERENCES project_management(project_management_Id)
);

-- Create employee_table
CREATE TABLE employee_table (
    employee_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    calculator_table_id INTEGER,
    FOREIGN KEY (calculator_table_id) REFERENCES calculator_table(calculator_table_id)
);

-- Create tasks table
CREATE TABLE tasks (
    tasks_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    estimated_work_hours_per_task INTEGER NOT NULL
);

-- Create employee_tasks table
CREATE TABLE employee_tasks (
    employee_id INTEGER NOT NULL,
    tasks_id INTEGER NOT NULL,
    PRIMARY KEY (employee_id, tasks_id),
    FOREIGN KEY (employee_id) REFERENCES employee_table(employee_id),
    FOREIGN KEY (tasks_id) REFERENCES tasks(tasks_id)
);

-- Create employee_subprojects table
CREATE TABLE employee_subprojects (
    employee_id INTEGER NOT NULL,
    subproject_id INTEGER NOT NULL,
    PRIMARY KEY (employee_id, subproject_id),
    FOREIGN KEY (employee_id) REFERENCES employee_table(employee_id),
    FOREIGN KEY (subproject_id) REFERENCES subprojects(subproject_id)
);

-- Test insertions
INSERT INTO client (client_company, client_email, client_name)
VALUES 
('Tech Solutions', 'contact@techsolutions.com', 'Tech Solutions Inc.');

INSERT INTO project_management (project_name, project_leader)
VALUES 
('Website Redesign', 'Claus');

INSERT INTO calculator_table (calculator_name, client_id, project_management_id)
VALUES ('Tech Solutions Calculator', 1, 1);

INSERT INTO employee_table (employee_name)
VALUES 
('Lars Cykeltyv'), 
('Henrik');

INSERT INTO tasks (task_name, estimated_work_hours_per_task)
VALUES ('Test multiple employees task', 10);

INSERT INTO subprojects (subproject_name, project_management_id)
VALUES 
('Backend', 1), 
('Frontend', 1);

INSERT INTO employee_subprojects (employee_id, subproject_id)
VALUES 
(1, 1), 
(2, 1), 
(2, 2);

select * from subprojects;

select * from employee_subprojects;

SELECT * FROM project_management;

select * from employee_table;

select * from tasks;



