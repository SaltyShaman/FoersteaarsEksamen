package org.example.foersteaarseksamen.models;

public class ProjectManagement {

    private String projectName;
    private String projectLeader;
    private long projectMannagementID; //ID is iniated outside the constructor, but still avaible for use

    public ProjectManagement()

        public ProjectManagement(String projectName, String projectLeader,) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
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

    public long getProjectMannagementID() {
        return projectMannagementID;
    }

    public void setProjectMannagementID(long projectMannagementID) {
        this.projectMannagementID = projectMannagementID;
    }


}
