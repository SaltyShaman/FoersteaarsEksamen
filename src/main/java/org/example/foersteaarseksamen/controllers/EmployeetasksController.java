package org.example.foersteaarseksamen.controllers;


import org.springframework.ui.Model;
import org.example.foersteaarseksamen.services.EmployeetasksService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeetasksController {

    private final EmployeetasksService employeetasksService;

    public EmployeetasksController(EmployeetasksService employeetasksService) {
        this.employeetasksService = employeetasksService;
    }

    @PostMapping("/assignEmployeeToTaskPost")
    public String assignEmployeeToTaskPost(@RequestParam int employeeId, Integer taskId) {
        employeetasksService.assignTaskToEmployee(employeeId, taskId);
        return "redirect:/seeAllTasks"; // from TaskController
    }

    @GetMapping("/assignEmployeeToTask")
    public String assignEmployeeToTask(Model model) {

        model.addAttribute("employees", employeetasksService.findAllEmployees());
        model.addAttribute("tasks", employeetasksService.findAllTasks());

        return "assign-employee-to-task";
    }
}
