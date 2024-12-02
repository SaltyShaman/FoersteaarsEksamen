package org.example.foersteaarseksamen.models;

public class Calcemp {

    //employee variables
    private String employeeName;
    private String workArea;
    private String task;
    private int estimatedHoursPerEmployee;

    //client variables
    private String clientCompany;
    private String clientName;

    //project variables
    private String projectName;
    private String projectLeader;

    //calculator variables
    private String calculatorName;

    public Calcemp() {
    }

    public Calcemp(String employeeName, String workArea, String task, int estimatedHoursPerEmployee,
                   String clientCompany, String clientName,
                   String projectName, String projectLeader) {
        this.employeeName = employeeName;
        this.workArea = workArea;
        this.task = task;
        this.estimatedHoursPerEmployee = estimatedHoursPerEmployee;

        this.clientCompany = clientCompany;
        this.clientName = clientName;

        this.projectName = projectName;
        this.projectLeader = projectLeader;

        this.calculatorName = calculatorName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    //join statements med sellecter ud fra de tabeller man ønsker at have med alias

    /*

    ingen nye ID

    og de ønskede kolonne navne

    her i model klassen skal man have de ting man ønsker at vise med som variabler


     */
}
