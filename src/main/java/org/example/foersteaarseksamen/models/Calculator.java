package org.example.foersteaarseksamen.models;

public class Calculator {

    private int calculatorTableId; //PRIMARY KEY
    private String calculatorName;
    private int client_id;           // FOREIGN KEY
    private int projectManagementId; //FOREIGN KEY

    public Calculator() {
    }

    public Calculator(int calculatorTableId, String calculatorName ,int client_id, int projectManagementId) {
        this.calculatorTableId = calculatorTableId;
        this.calculatorName = calculatorName;
        this.client_id = client_id;
        this.projectManagementId = projectManagementId;
    }

    public int getCalculatorTableId() {
        return calculatorTableId;
    }

    public void setCalculatorTableId(int calculatorTableId) {
        this.calculatorTableId = calculatorTableId;
    }

    public String getCalculatorName() {
        return calculatorName;
    }

    public void setCalculatorName(String calculatorName) {
        this.calculatorName = calculatorName;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProjectManagementId() {
        return projectManagementId;
    }

    public void setProjectManagementId(int projectManagementId) {
        this.projectManagementId = projectManagementId;
    }
}
