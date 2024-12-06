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

    public void CreateEmployee(String employeeName, String workArea,
                               String task, int estimatedHoursPerEmployee) {
        String query = "INSERT INTO employee_table (employee_name, work_area, task, estimated_work_hours_per_employee, calculator_table_id) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, employeeName, workArea, task, estimatedHoursPerEmployee, null);
    }


    //custom wrapper made with help from chatGPT nov 30. The help was understanding the datatype mattered
    public List<Employee> ReadAllEmployees() {
        String query = "SELECT * FROM employee_table";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setEmployeeName(rs.getString("employee_name"));
            employee.setWorkArea(rs.getString("work_area"));
            employee.setTask(rs.getString("task"));
            employee.setEstimatedHoursPerEmployee(rs.getInt("estimated_work_hours_per_employee"));
            employee.setCalculatorTableId(rs.getInt("calculator_table_id"));
            return employee;
        });
    }


    /*
    1: find en liste over alle calculators
    2: set employee calculatortableid til en liste baseret på calculatornavn
     */



}
