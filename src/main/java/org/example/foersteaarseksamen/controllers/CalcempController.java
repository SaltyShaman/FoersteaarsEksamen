package org.example.foersteaarseksamen.controllers;

import org.example.foersteaarseksamen.models.Calcemp;
import org.example.foersteaarseksamen.services.CalcempService;
import org.example.foersteaarseksamen.services.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcempController {

    private final CalcempService calcempService;

    public CalcempController(CalcempService calcempService) {
        this.calcempService = calcempService;
    }



    @GetMapping("/readAllCalculators")
    public String readAllCalculators(Model model) {
        model.addAttribute("calculators", calcempService.findAllCalculators());
        return "calculator-sellector";
    }

    @PostMapping("/getCalculatorData")
    public String getCalcEmpDetailsFromDropdown(@RequestParam String calculatorName) {
        return "redirect:/getCalculatorDataDisplay?calculatorName=" + calculatorName;
    }

    @GetMapping("/getCalculatorDataDisplay")
    public String getCalculatorDataDisplay(Model model, @RequestParam String calculatorName) {
        model.addAttribute("calcEmp", calcempService.getCalcEmpDetails(calculatorName));
        return "calculator-tool";
    }



}
