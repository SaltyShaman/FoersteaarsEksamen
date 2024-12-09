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
    private final TaskRepository taskRepository;

    public SubprojectService(SubprojectRepository subprojectRepository, TaskRepository taskRepository) {
        this.subprojectRepository = subprojectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Subproject> findAllSubprojects(){
        return subprojectRepository.findAllSubprojects();
    }

    public void assignEmployeeToSubproject(Integer employeeId, Integer subprojectId) {
        subprojectRepository.assignEmployeeToSubproject(employeeId, subprojectId);
    }

    public List<Subproject> findSubprojectsByCalculatorName(String calculatorName) {
        return subprojectRepository.findSubprojectsByCalculatorName(calculatorName);
    }

    //Made with ChatGPT 8 december
    public Map<Subproject, List<Employee>> findSubprojectsWithEmployees(String calculatorName) {
        // Fetch the list of subprojects associated with the calculator
        List<Subproject> subprojects = subprojectRepository.findSubprojectsByCalculatorName(calculatorName);

        // Prepare a map to associate subprojects with their respective employees
        Map<Subproject, List<Employee>> subprojectsWithEmployees = new LinkedHashMap<>();

        for (Subproject subproject : subprojects) {
            // Fetch employees assigned to the subproject
            List<Employee> employees = subprojectRepository.findEmployeesBySubprojectId(subproject.getSubprojectId());

            // Populate tasks for each employee
            for (Employee employee : employees) {
                employee.setTasks(taskRepository.findTasksByEmployeeId(employee.getEmployeeId()));
            }

            subprojectsWithEmployees.put(subproject, employees);
        }

        return subprojectsWithEmployees;
    }


}