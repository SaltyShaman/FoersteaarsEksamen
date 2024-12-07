package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.models.Task;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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




    //singlular use without seeing attached employees
    public List<Task> getAllTasks() {
        String query = "SELECT * FROM tasks";
        RowMapper rowMapper1 = new BeanPropertyRowMapper(Task.class);
        return jdbcTemplate.query(query, rowMapper1);
    }

    /*
    mål:, update task, read task, tilknyt task til employee

     */
}
