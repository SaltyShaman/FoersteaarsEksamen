package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Employee;
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

    public void createEmployee(String employeeName,
                               Integer tasksId, Integer calculatorTableId) {
        employeeRepository.CreateEmployee(employeeName, tasksId, calculatorTableId);
    }

    public List<Employee> ReadAllEmployees() {
        return employeeRepository.ReadAllEmployees();
    }






}
