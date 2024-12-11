package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //Create
    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        return "create-employee";
    }

    //KSG, required = false aquired from ChatGPT
    @PostMapping("/createEmployeePost")
    public String createEmployee(@RequestParam String employeeName,
                                 @RequestParam(required = false) Integer calculatorTableId) {
        employeeService.createEmployee(employeeName,  calculatorTableId);
        return "redirect:/selectAllEmployees";
    }


    @GetMapping("/selectAllEmployees")
    public String selectAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.ReadAllEmployees());
        return "employee-overview";
    }



}

