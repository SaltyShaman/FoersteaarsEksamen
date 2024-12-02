package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        int client_id = calculatorService.getClientId(clientCompany);
        model.addAttribute("client_id", client_id);
        return "register-new-calculator";
    }

    //inspired by ChatGPt dec 1
    @GetMapping("/readProjectId")
    public String readProjectId(@RequestParam String projectName, Model model) {
        int projectId = calculatorService.getProjectManagementId(projectName);
        model.addAttribute("projectId", projectId);
        return "register-new-calculator";
    }


    @PostMapping("/createCalculatorPost")
    public String createCalculator(@RequestParam String calculatorName,
                                   @RequestParam int client_id,
                                   @RequestParam int projectManagementId) {
        calculatorService.createCalculator(calculatorName, client_id, projectManagementId);
        return "redirect:/calculator-tool";
    }

    @GetMapping("/createCalculator")
    public String showCalculator(Model model) {
        model.addAttribute("clients", calculatorService.getAllClients());
        return "register-new-calculator";
    }




}
