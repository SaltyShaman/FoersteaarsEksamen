package org.example.foersteaarseksamen.controllers;


import org.example.foersteaarseksamen.services.ClientService;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }



}
