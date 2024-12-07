package org.example.foersteaarseksamen.controllers;



import org.example.foersteaarseksamen.models.Task;
import org.example.foersteaarseksamen.services.TaskService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTaskPost")
    public String createTaskPost(@ModelAttribute Task task) {
        taskService.createTask(task);

        return "redirect:/seeAllTasks"; // yet to be made
    }

    @GetMapping("/createTask")
    public String createTask(Model model) {
         return "create-task";
    }
}
