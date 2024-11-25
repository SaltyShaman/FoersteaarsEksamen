package org.example.foersteaarseksamen.controllers;

import org.springframework.ui.Model;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.services.ProjectManagementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectManagementController {

    private final ProjectManagementServices projectManagementServices;

    public ProjectManagementController(ProjectManagementServices projectManagementServices) {
        this.projectManagementServices = projectManagementServices;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    //show the form
    @GetMapping("/create")
    public String showCreateProjectForm(Model model) {
        model.addAttribute("projectManagement", new ProjectManagement());
        return "register-new-project";
    }

    //create register form
    @PostMapping("/createPost")
    public String createProject(@ModelAttribute("projectManagement")
                                    ProjectManagement projectManagement, Model model) {
    if (projectManagementServices.projectExists(projectManagement.getProjectName())) { //it is a comparison
        model.addAttribute ("message", "Project already exists");
        return "register-new-project"; //return to the register form
    }
    projectManagementServices.createProjectManagement(projectManagement);
    model.addAttribute("projects", projectManagementServices.getAllProjectManagements());
    return "redirect:/projects-overview"; //redirect to listing page
    }

    @GetMapping("/selectAllFromProjectManagement")
    public String selectAllFromProjectManagement(Model model) {
        model.addAttribute("projectManagements", projectManagementServices.getAllProjectManagements());
        return "projects-overview";
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
        return "redirect:/projects-overview";
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

        return "redirect:/projects-overview";
    }


}
