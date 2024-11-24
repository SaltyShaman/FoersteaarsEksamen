package org.example.foersteaarseksamen.controllers;


import ch.qos.logback.core.model.Model;
import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/add-client")
    public String addClient(@ModelAttribute("client") Client client, Model model){
        try {
            if (ClientService)
        } catch (Exception e) {
            model.addAttribute("message", "Error while adding client: " + e.getMessage());
            return "add-client";
        }
    }
}
