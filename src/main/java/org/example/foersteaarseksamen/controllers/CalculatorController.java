package org.example.foersteaarseksamen.controllers;


import ch.qos.logback.core.model.Model;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.services.CalculatorService;
import org.example.foersteaarseksamen.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/readClientId")
    public String readClientId(@RequestParam String clientCompany, Model model) {
        // Retrieve clientId for the selected company
        int clientId = calculatorService.getClientId(clientCompany);
        model.addAtribute ("clientId", clientId);
        return "register-new-calculator";
    }

    @GetMapping("/readProjectId")
    public String readProjectId(@RequestParam String projectName, Model model) {
        int projectId = calculatorService.getProjectManagementId(projectName);
        model.addAtribute ("projetId", projectId);
        return "register-new-calculator";
    }


}
