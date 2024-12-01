package org.example.foersteaarseksamen.models;

public class Calculator {

    private int calculatorTableId; //PRIMARY KEY
    private int clientId;           // FOREIGN KEY
    private int projectManagementId; //FOREIGN KEY

    public Calculator() {
    }

    public Calculator(int calculatorTableId, int clientId, int projectManagementId) {
        this.calculatorTableId = calculatorTableId;
        this.clientId = clientId;
        this.projectManagementId = projectManagementId;
    }

    public int getCalculatorTableId() {
        return calculatorTableId;
    }

    public void setCalculatorTableId(int calculatorTableId) {
        this.calculatorTableId = calculatorTableId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProjectManagementId() {
        return projectManagementId;
    }

    public void setProjectManagementId(int projectManagementId) {
        this.projectManagementId = projectManagementId;
    }
}
