package org.example.foersteaarseksamen.controllers;

import org.springframework.ui.Model;
import org.example.foersteaarseksamen.models.ProjectManagement;
import org.example.foersteaarseksamen.services.ProjectManagementServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectManagementController {

    private final ProjectManagementServices projectManagementServices;

    public ProjectManagementController(ProjectManagementServices projectManagementServices) {
        this.projectManagementServices = projectManagementServices;
    }
// index returning fungerer
// select all fungerer på HTML tabellen

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/selectAllFromProjectManagement")
    public String selectAllFromProjectManagement(Model model) {
        model.addAttribute("projectManagements", projectManagementServices.getAllProjectManagements());
        return "projects-overview";
    }


    //show the form
    @GetMapping("/create")
    public String showCreateProjectForm(Model model) {
        return "register-new-project";
    }

    // create post is adding project_managements to the database
    @PostMapping("/createPost")
    public String createProject(@RequestParam String projectName, @RequestParam String projectLeader) {
        projectManagementServices.createProjectManagement(projectName, projectLeader);
        return  "redirect:/";
    }

   /*
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

*/


    //Delete also leads to listing page

    /*steps:
    1 fetch the project name on from the database
    2: store the name in a new variable
    3: delete the project name using the variable
    */

/*
    @PostMapping("/delete/{projectName}")     //made with help from ChatGPT 24/11/24
    public String deleteProject(@PathVariable("projectName") String projectName) {
        // Use the service to retrieve and delete the project
        ProjectManagement project = projectManagementServices.getProjectManagementByProjectName(projectName);
        projectManagementServices.deleteProjectManagement(project);

        return "redirect:/projects-overview";
    }

*/
}



