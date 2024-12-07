package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Task;
import org.example.foersteaarseksamen.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }

}
