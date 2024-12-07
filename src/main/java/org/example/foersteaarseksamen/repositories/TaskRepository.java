package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbcTemplate;

    public TaskRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTask(Task task) {
        String query = "INSERT INTO tasks(task_name, estimated_work_hours_per_task) (VALUES ?, ?)";
        jdbcTemplate.update(query, task.getTaskName(), task.getEstimatedWorkHoursPerTask());
    }

    /*
    mål: create task, update task, read task

     */
}
