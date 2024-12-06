package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
/*
    TO-DO: tilføje ny employee til projektet fra en dropdown menu
  */

    //Employeees are created without assignd foreign keys
    public void CreateEmployee(String employeeName, Integer tasksId, Integer calculatorTableId) {
        String query = "INSERT INTO employee_table (employee_name, tasks_id, calculator_table_id) VALUES (?, ?, ?)";

        jdbcTemplate.update(query, employeeName, tasksId, calculatorTableId);
    }




    //custom wrapper made with help from chatGPT nov 30. Updated dec 6-8 to include foreign key tasks The help was understanding the datatype mattered
    public List<Employee> ReadAllEmployees() {
        String query = "SELECT * FROM employee_table";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            // Use the parameterized constructor
            return new Employee(
                    rs.getInt("employee_id"),
                    rs.getString("employee_name"),
                    rs.getInt("tasks_id"),
                    rs.getInt("calculator_table_id")
            );
        });
    }








}
