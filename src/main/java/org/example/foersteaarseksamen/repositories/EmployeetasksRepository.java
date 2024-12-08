package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeetasksRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeetasksRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void assignTaskToEmployee(int employeeId, Integer taskId) {
        String query = "INSERT INTO employee_tasks (employee_id, tasks_id) VALUES (?, ?)";
        jdbcTemplate.update(query, employeeId, taskId);
    }

    public List<Employee> findAllEmployees() {
        String query = "SELECT * FROM employee_table";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getInt("employee_id"));
            employee.setEmployeeName(rs.getString("employee_name"));
            return employee;
        });
    }

    public List<Task> findAllTasks() {
        String query = "SELECT * FROM tasks";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            Task task = new Task();
            task.setTaskId(rs.getInt("tasks_id"));
            task.setTaskName(rs.getString("task_name"));
            return task;
        });
    }
}
