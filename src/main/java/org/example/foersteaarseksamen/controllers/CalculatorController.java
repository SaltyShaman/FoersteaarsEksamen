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



    @PostMapping("/createCalculatorPost")
    public String createCalculator(@RequestParam String calculatorName,
                                   @RequestParam int client_id,
                                   @RequestParam int projectManagementId) {
        calculatorService.createCalculator(calculatorName, client_id, projectManagementId);
        return "redirect:/calculatorTool";
    }

    @GetMapping("/calculatorTool")
    public String calculatorTool(Model model) {
        return "calculator-tool";
    }

    @GetMapping("/createCalculator")
    public String showCalculator(Model model) {
        model.addAttribute("clients", calculatorService.getAllClients());
        model.addAttribute("projects", calculatorService.getAllProjects());
        return "register-new-calculator";
    }




}
