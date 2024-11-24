package org.example.foersteaarseksamen.controllers;

import org.springframework.ui.Model;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.services.ProjectManagementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects") //redirect point
public class ProjectManagementController {

    private final ProjectManagementServices projectManagementServices;

    @Autowired
    public ProjectManagementController(ProjectManagementServices projectManagementServices) {
        this.projectManagementServices = projectManagementServices;
    }

    //show the form
    @GetMapping("/create")
    public String showCreateProjectForm(Model model) {
        model.addAttribute("projectManagement", new ProjectManagement());
        return "register-new-project";
    }

    //create register form
    @PostMapping("/create")
    public String createProject(@ModelAttribute("projectManagement")
                                    ProjectManagement projectManagement, Model model) {
    if (projectManagementServices.projectExists(projectManagement.getProjectName())) { //it is a comparison
        model.addAttribute ("message", "Project already exists");
        return "register-new-project"; //return to the register form
    }
    projectManagementServices.createProjectManagement(projectManagement);
    return "redirect:/projects?message=Project+successfully+created"; //redirect to listing page
    }

    //rest of the methods are going to be used outside of register-new-project.html

    //Update redirects to listings page
    @PostMapping("/update")
    public String updateProject(@ModelAttribute("projectManagement")
                                    ProjectManagement projectManagement, Model model) {
        if (projectManagementServices.projectExists(projectManagement.getProjectName())) {
            model.addAttribute ("message", "Project not found");
        }
        projectManagementServices.updateProjectManagement(projectManagement);
        return "redirect:/projects?message=Project+successfully+updated";
    }

    //shows all projects
    @GetMapping("/projects")
    public String showProjectsOverview(Model model) {
        List<ProjectManagement> projects = projectManagementServices.getAllProjectManagements();
        model.addAttribute("projects", projects);
        return "projects-overview"; // To see the list
    }



    //Delete also leads to listing page

    /*steps:
    1 fetch the project name on from the database
    2: store the name in a new variable
    3: delete the project name using the variable
    */

    @PostMapping("/delete/{projectName}")     //made with help from ChatGPT 24/11/24
    public String deleteProject(@PathVariable("projectName") String projectName) {
        // Use the service to retrieve and delete the project
        ProjectManagement project = projectManagementServices.getProjectManagementByProjectName(projectName);
        projectManagementServices.deleteProjectManagement(project);

        return "redirect:/projects?message=Project+successfully+deleted";
    }


}
