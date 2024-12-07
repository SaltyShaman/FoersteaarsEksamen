package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Task;
import org.example.foersteaarseksamen.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(String taskName, Integer estimatedWorkHoursPerTask) {
        taskRepository.createTask(taskName, estimatedWorkHoursPerTask);
    }

    public List<Task> getAllTasks() {
       return taskRepository.getAllTasks();
    }

}
