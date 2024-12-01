package org.example.foersteaarseksamen.controllers;


import ch.qos.logback.core.model.Model;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.repositories.CalculatorRepository;
import org.example.foersteaarseksamen.services.CalculatorService;
import org.example.foersteaarseksamen.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    //inspired by ChatGPt dec 1
    @GetMapping("/readClientId")
    public String readClientId(@RequestParam String clientCompany, Model model) {
        int clientId = calculatorService.getClientId(clientCompany);
        model.addAttribute("clientId", clientId);
        return "register-new-calculator";
    }



    //inspired by ChatGPt dec 1
    @GetMapping("/readProjectId")
    public String readProjectId(@RequestParam String projectName, Model model) {
        int projectId = calculatorService.getProjectManagementId(projectName);
        model.addAtribute ("projetId", projectId);
        return "register-new-calculator";
    }

    @PostMapping("/createCalculatorPost")
    public String createCalculator(@RequestParam int clientId,
                                   @RequestParam int projectManagementId) {
        return "redirect:/calculator-tool";
    }

    @GetMapping("/crateCalculator")
    public String showCalculator(Model model) {
        return "register-new-calculator";
    }


}
