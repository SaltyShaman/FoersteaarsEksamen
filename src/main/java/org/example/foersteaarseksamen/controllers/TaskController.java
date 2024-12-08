package org.example.foersteaarseksamen.controllers;



import org.example.foersteaarseksamen.models.Task;
import org.example.foersteaarseksamen.services.TaskService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTaskPost")
    public String createTaskPost(@RequestParam String taskName,
                                 @RequestParam Integer estimatedWorkHoursPerTask) {
        taskService.createTask(taskName, estimatedWorkHoursPerTask);

        return "redirect:/seeAllTasks";
    }

    @GetMapping("/createTask")
    public String createTask(Model model) {
         return "create-task";
    }

    @GetMapping("/seeAllTasks")
    public String seeAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "see-all-tasks";
    }

    @PostMapping("/deleteTask")
    public String deleteTask(@RequestParam Integer taskId) {

        taskService.deleteTask(taskId);

        return "redirect:/seeAllTasks";
    }


}
