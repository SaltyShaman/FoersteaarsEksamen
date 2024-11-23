package org.example.foersteaarseksamen.services;

import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.repositories.ProjectManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectManagementServices {

    private final ProjectManagementRepository projectManagementRepository;

    @Autowired
    public ProjectManagementServices(ProjectManagementRepository projectManagementRepository) {
        this.projectManagementRepository = projectManagementRepository;
    }

    public void createProjectManagement(ProjectManagement projectManagement) {
        projectManagementRepository.createProjectManagement(projectManagement);
    }

    public void updateProjectManagement(ProjectManagement projectManagement) {
        projectManagementRepository.updateProjectManagement(projectManagement);
    }

    public void deleteProjectManagement(ProjectManagement projectManagement) {
        projectManagementRepository.deleteProjectManagement(projectManagement);
    }

    public ProjectManagement getProjectManagementByProjectName(String projectName) {
       if (projectName == null || projectName.isEmpty()) { // error handling incase say typo or empty tabel
            throw new IllegalArgumentException("Project name cannot be null or empty");
       }
        return projectManagementRepository.getProjectManagementByProjectName(projectName);
    }

    /*
    Boolean is duplicate check for controller logic when making a new project.
    Each project has to have a unique name that is not null
     */

    public boolean projectExists(String projectName) {
        return getProjectManagementByProjectName(projectName) != null;
    }

    public List<ProjectManagement> getAllProjectManagements() {
        return projectManagementRepository.getAllProjectManagements();
    }
}
