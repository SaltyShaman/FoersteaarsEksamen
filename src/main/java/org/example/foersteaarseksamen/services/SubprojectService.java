package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.Subproject;
import org.example.foersteaarseksamen.repositories.SubprojectRepository;
import org.example.foersteaarseksamen.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubprojectService {

    private final SubprojectRepository subprojectRepository;

    public SubprojectService(SubprojectRepository subprojectRepository) {
        this.subprojectRepository = subprojectRepository;
    }

    public List<Subproject> findAllSubprojects(){
        return subprojectRepository.findAllSubprojects();
    }

    public void assignEmployeeToSubproject(Integer employeeId, Integer subprojectId) {
        // Call the repository method to handle the database insertion
        subprojectRepository.assignEmployeeToSubproject(employeeId, subprojectId);
    }

    public List<Subproject> findSubprojectsByCalculatorName(String calculatorName) {
        return subprojectRepository.findSubprojectsByCalculatorName(calculatorName);
    }

    public Map<Subproject, List<Employee>> findSubprojectsWithEmployees(String calculatorName) {
        // Fetch the list of subprojects associated with the calculator
        List<Subproject> subprojects = subprojectRepository.findSubprojectsByCalculatorName(calculatorName);

        // Prepare a map to associate subprojects with their respective employees
        Map<Subproject, List<Employee>> subprojectsWithEmployees = new LinkedHashMap<>();

        for (Subproject subproject : subprojects) {
            List<Employee> employees = subprojectRepository.findEmployeesBySubprojectId(subproject.getSubprojectId());
            subprojectsWithEmployees.put(subproject, employees);
        }

        return subprojectsWithEmployees;
    }

}
