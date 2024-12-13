package org.example.foersteaarseksamen.controllers;

import org.example.foersteaarseksamen.models.Calcemp;
import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.services.CalcempService;
import org.example.foersteaarseksamen.services.CalculatorService;
import org.example.foersteaarseksamen.services.SubprojectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalcempController {

    private final CalcempService calcempService;
    private final SubprojectService subprojectService;

    public CalcempController(CalcempService calcempService, SubprojectService subprojectService) {
        this.calcempService = calcempService;
        this.subprojectService = subprojectService;
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

        model.addAttribute("subprojects", subprojectService.findSubprojectsWithEmployees(calculatorName));

        return "calculator-tool";
    }

    @PostMapping("/attachEmployeeToForeignKeyPost")
    public String attachEmployeeToForeignKey(@RequestParam int employeeId,
                                             @RequestParam int calculatorTableId) {
        calcempService.attachEmployeeToCalculatorId(employeeId, calculatorTableId);
        return "redirect:/selectAllEmployees";
    }



    @GetMapping("/attachEmployeeToForeignKey")
    public String showAttachEmployeeToForeignKey(Model model) {

        // Add data to the model
        model.addAttribute("employees", calcempService.getAllEmployees());
        model.addAttribute("calculators", calcempService.getAllCalculators());

        return "attach-foreign-key-to-employee";
    }



}