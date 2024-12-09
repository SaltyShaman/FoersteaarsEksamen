package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.models.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTask(String taskName, Integer estimatedWorkHoursPerTask) {
        String query = "INSERT INTO tasks (task_name, estimated_work_hours_per_task) VALUES (?, ?)";
        jdbcTemplate.update(query, taskName, estimatedWorkHoursPerTask);
    }

    //without seeing attached employees
    public List<Task> getAllTasks() {
        String query = "SELECT tasks_id, task_name, estimated_work_hours_per_task FROM tasks";

        // Directly map the result set to Task objects using RowMapper
        return jdbcTemplate.query(query, new RowMapper<Task>() {
            @Override
            public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Task(
                        rs.getInt("tasks_id"),
                        rs.getString("task_name"),
                        rs.getInt("estimated_work_hours_per_task")
                );
            }
        });
    }

    public void deleteTask(Integer taskId) {
        String query = "DELETE FROM tasks WHERE tasks_id = ?";
        jdbcTemplate.update(query, taskId);
    }


    public List<Task> findTasksByEmployeeId(int employeeId) {
        String query = """
        SELECT t.tasks_id, t.task_name, t.estimated_work_hours_per_task
        FROM employee_tasks et
        INNER JOIN tasks t ON et.tasks_id = t.tasks_id
        WHERE et.employee_id = ?
        """;

        return jdbcTemplate.query(query, (rs, rowNum) -> new Task(
                rs.getInt("tasks_id"),
                rs.getString("task_name"),
                rs.getInt("estimated_work_hours_per_task")
        ), employeeId);
    }


}
