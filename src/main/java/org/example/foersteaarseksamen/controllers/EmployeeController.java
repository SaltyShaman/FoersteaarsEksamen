package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/createEmployee")
    public String createEmployee(Model model) {
        return "create-employee";
    }

    /*
//to-do: redirect into the calculator page
         read specific employee
     */
    @PostMapping("/createEmployeePost")
    public String createEmployee(@RequestParam String employeeName,
                                 @RequestParam String workArea,
                                 @RequestParam String task,
                                 @RequestParam double estimatedHoursPerEmployee,
                                 @RequestParam Integer calculatorTableId) {
        return "redirect:/calculator";
    }

    @GetMapping("/calculator")
    public String calculator(Model model) {
        return "calculator-tool";
    }


    @GetMapping("/selectAllEmployees")
    public String selectAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.ReadAllEmployees());
        return "calculator-tool";
    }

}

