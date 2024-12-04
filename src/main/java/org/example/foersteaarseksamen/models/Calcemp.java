package org.example.foersteaarseksamen.models;

import java.util.List;

public class Calcemp {

    // Employee is treated as list of objects to be fetched from the SQL tabel
    private List <Employee> employees;

    /*
    Variables:
    employee_name
    work_area
    task
    estimated_work_hours_per_employee INTEGER
    calculator_table_id INTEGER and foreign key
     */

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
// Corrected parameterized constructor
    public Calcemp(List<Employee> employees, String clientCompany, String clientName,
                   String projectName, String projectLeader, String calculatorName, int calculatorTableId) {
        this.employees = employees;
        this.clientCompany = clientCompany;
        this.clientName = clientName;
        this.projectName = projectName;
        this.projectLeader = projectLeader;
        this.calculatorName = calculatorName;
        this.calculatorTableId = calculatorTableId;
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

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
