package org.example.foersteaarseksamen.models;

import java.util.List;

public class Subproject {

    //common created

    private Integer subprojectId; //PRIMARY KEY
    private String subprojectName;
    private Integer projectManagementId; // FOREIGN KEY LINKS TO TOOL

    public Subproject() {
    }

    public Subproject(Integer subprojectId,String subprojectName, Integer projectManagementId) {

        this.subprojectId = subprojectId;
        this.subprojectName = subprojectName;
        this.projectManagementId = projectManagementId;
    }

    public Integer getSubprojectId() {
        return subprojectId;
    }

    public void setSubprojectId(Integer subprojectId) {
        this.subprojectId = subprojectId;
    }

    public String getSubprojectName() {
        return subprojectName;
    }

    public void setSubprojectName(String subprojectName) {
        this.subprojectName = subprojectName;
    }

    public Integer getProjectManagementId() {
        return projectManagementId;
    }

    public void setProjectManagementId(Integer projectManagementId) {
        this.projectManagementId = projectManagementId;
    }


}
