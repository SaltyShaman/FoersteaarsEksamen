package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*
    read all
    read specific
     */

    public void createEmployee(String employeeName, String workArea,
                               String task, int estimatedHoursPerEmployee, Integer calculatorTableId ) {
        employeeRepository.CreateEmployee(employeeName, workArea, task, estimatedHoursPerEmployee, calculatorTableId);
    }

    public List<Employee> ReadAllEmployees() {
        return employeeRepository.ReadAllEmployees();
    }


}
