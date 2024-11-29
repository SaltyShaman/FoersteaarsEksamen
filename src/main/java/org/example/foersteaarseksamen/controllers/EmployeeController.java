package org.example.foersteaarseksamen.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {


    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        return "create-employee";
    }

//to-do: redirect into the calculator page

    @PostMapping("/createEmployeePost")
    public String createEmployee(@RequestParam String employeeName, @RequestParam String workArea,
                                 @RequestParam String task, @RequestParam String estimatedHoursPerEmployee) {
        return "redirect/calculator page";
    }

}

