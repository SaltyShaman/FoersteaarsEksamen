package org.example.foersteaarseksamen.models;

import java.util.List;

public class Calcemp {

    // Employee variables
    private List<String> employeeNames; // Updated to support multiple employees
    private String workArea;
    private String task;
    private int estimatedHoursPerEmployee;

    // Client variables
    private String clientCompany;
    private String clientName;

    // Project variables
    private String projectName;
    private String projectLeader;

    // Calculator variables
    private String calculatorName;
    private int calculatorTableId;

    // Default constructor
    public Calcemp() {
    }

    // Parameterized constructor
    public Calcemp(List<String> employeeNames, String workArea, String task, int estimatedHoursPerEmployee,
                   String clientCompany, String clientName,
                   String projectName, String projectLeader, String calculatorName, int calculatorTableId) {
        this.employeeNames = employeeNames;
        this.workArea = workArea;
        this.task = task;
        this.estimatedHoursPerEmployee = estimatedHoursPerEmployee;
        this.clientCompany = clientCompany;
        this.clientName = clientName;
        this.projectName = projectName;
        this.projectLeader = projectLeader;
        this.calculatorName = calculatorName;
        this.calculatorTableId = calculatorTableId;
    }

    // Getters and setters
    public List<String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(List<String> employeeNames) {
        this.employeeNames = employeeNames;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getEstimatedHoursPerEmployee() {
        return estimatedHoursPerEmployee;
    }

    public void setEstimatedHoursPerEmployee(int estimatedHoursPerEmployee) {
        this.estimatedHoursPerEmployee = estimatedHoursPerEmployee;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getCalculatorName() {
        return calculatorName;
    }

    public void setCalculatorName(String calculatorName) {
        this.calculatorName = calculatorName;
    }

    public int getCalculatorTableId() {
        return calculatorTableId;
    }

    public void setCalculatorTableId(int calculatorTableId) {
        this.calculatorTableId = calculatorTableId;
    }
}
