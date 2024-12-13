package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Employee;
import org.example.foersteaarseksamen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(String employeeName, Integer calculatorTableId) {
        employeeRepository.CreateEmployee(employeeName, calculatorTableId);
    }

    public List<Employee> ReadAllEmployees() {
        return employeeRepository.ReadAllEmployees();
    }

}
