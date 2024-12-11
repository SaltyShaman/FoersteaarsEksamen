package org.example.foersteaarseksamen.services;


import org.example.foersteaarseksamen.models.Client;
import org.example.foersteaarseksamen.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(String clientCompany, String clientEmail, String clientName) {
        clientRepository.addClient(clientCompany, clientEmail, clientName);
    }

    public List<Client> showAllClients() {
        return clientRepository.showAllClients();
    }

    public void updateClient(String clientCompany, String clientName, String clientEmail, String oldClientEmail) {
        clientRepository.updateClient(clientCompany, clientName, clientEmail, oldClientEmail);
    }


    public void deleteClient(int client_id) {
        clientRepository.deleteClient(client_id);
    }






}
