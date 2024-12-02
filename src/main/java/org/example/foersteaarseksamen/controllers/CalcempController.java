package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.CalcempService;
import org.example.foersteaarseksamen.services.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalcempController {

    private final CalcempService calcempService;

    public CalcempController(CalcempService calcempService) {
        this.calcempService = calcempService;
    }

    @GetMapping("/readAllCalculators")
    public String readAllCalculators(Model model) {
        model.addAttribute("calculators", calcempService.findAllCalculators());
        return "calculator-tool";
    }

}
