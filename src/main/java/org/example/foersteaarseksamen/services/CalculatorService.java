package org.example.foersteaarseksamen.services;

import org.example.foersteaarseksamen.models.Calculator;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.repositories.CalculatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void createCalculator (String calculatorName, int client_id, int projectManagementId) {
        calculatorRepository.createCalculator(calculatorName, client_id, projectManagementId);
    }


    public List<Client> getAllClients() {
        return calculatorRepository.getAllClients();
    }

    public List<ProjectManagement> getAllProjects() {
        return calculatorRepository.getAllProjects();
    }

    public List<Calculator> findAllCalculators() {
        return calculatorRepository.findAllCalculators();
    }
}
