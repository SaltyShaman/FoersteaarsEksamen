package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //kun create og read

    public void createEmployee(String employeeName, String workArea,
                               String task, String estimatedHoursPerEmployee) {
        employeeRepository.CreateEmployee(employeeName, workArea, task, estimatedHoursPerEmployee);
    }



}
