package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //kun create og read

    public void CreateEmployee(String employeeName, String workArea,
                               String task, String estimatedHoursPerEmployee) {
        String query = "INSERT INTO employee_table (employee_name, work_area, task, estimated_work_hours_per_employee) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, employeeName, workArea, task, estimatedHoursPerEmployee);
    }

}
