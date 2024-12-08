package org.example.foersteaarseksamen.controllers;

import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.services.EmployeeService;
import org.springframework.ui.Model;
import org.example.foersteaarseksamen.services.SubprojectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubprojectController {

    private final SubprojectService subprojectService;
    private final EmployeeService employeeService;

    public SubprojectController(SubprojectService subprojectService, EmployeeService employeeService) {
        this.subprojectService = subprojectService;
        this.employeeService = employeeService;
    }

    @GetMapping("/subprojectsEmployeeAssign")
    public String subprojectsEmployeeAssign(Model model) {

        model.addAttribute("employees", employeeService.ReadAllEmployees());
        model.addAttribute("subprojects", subprojectService.findAllSubprojects());

        return "assign-employee-to-a-subproject";
    }

    @PostMapping("/subprojectsEmployeeAssignPost")
    public String subprojectsEmployeeAssignPost(@RequestParam Integer employeeId,
                                                @RequestParam Integer subprojectId){
        subprojectService.assignEmployeeToSubproject(employeeId, subprojectId);
        return "redirect:/selectAllFromProjectManagement"; //From ProjectManagementController
    }

}
