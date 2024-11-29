package org.example.foersteaarseksamen.models;

public class ProjectManagement {

    private int projectManagementId; //ID is generated in the SQL database
    private String projectName;
    private String projectLeader;

    public ProjectManagement(){
    }


    public ProjectManagement(int projectManagementId, String projectName, String projectLeader) {
        this.projectManagementId = projectManagementId;
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    public int getProjectManagementId() {
        return projectManagementId;
    }

    public void setProjectManagementId(int projectManagementId) {
        this.projectManagementId = projectManagementId;
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
}
