package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    //Create
    @GetMapping("/addClient")
    public String showCreateClientForm(Model model) {
        return "register-new-client";
    }
    @PostMapping("/addClient")
    public String addClient(@RequestParam String clientCompany, @RequestParam String clientEmail,@RequestParam String clientName) {
       clientService.addClient(clientCompany, clientEmail, clientName);
        return "redirect:/";
    }

    //Read
    @GetMapping("/selectAllClients")
    public String selectAllClients(Model model) {
        model.addAttribute("clients", clientService.showAllClients());
        return "client-overview.html";
    }

    //Update

    //Delete
    @PostMapping("/removeClient")
    public String removeClient(@RequestParam long clientID) {
        clientService.removeClient(clientID);
        return "redirect:/selectAllClients";
    }



}
