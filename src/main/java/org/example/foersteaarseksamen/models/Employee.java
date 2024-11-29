package org.example.foersteaarseksamen.models;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String workArea;
    private String task;
    private String estimatedHoursPerEmployee;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String workArea, String task, String estimatedHoursPerEmployee) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.workArea = workArea;
        this.task = task;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getEstimatedHoursPerEmployee() {
        return estimatedHoursPerEmployee;
    }

    public void setEstimatedHoursPerEmployee(String estimatedHoursPerEmployee) {
        this.estimatedHoursPerEmployee = estimatedHoursPerEmployee;
    }
}


