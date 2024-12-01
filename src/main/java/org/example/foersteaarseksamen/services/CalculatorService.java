package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.repositories.CalculatorRepository;
import org.example.foersteaarseksamen.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private final CalculatorRepository calculatorRepository;

    public CalculatorService(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    public int getClientId(String clientCompany) {
        return calculatorRepository.getClientId(clientCompany);
    }

    public int getProjectManagementId(String projectName) {
        return calculatorRepository.getProjectManagementId(projectName);
    }

    public void createCalculator (int clientId, int projectManagementId) {
        calculatorRepository.createCalculator(clientId, projectManagementId);
    }

}
