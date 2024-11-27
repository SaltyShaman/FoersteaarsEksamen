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
/*
    public Client showClient(String clientEmail) {
        if (clientEmail == null || clientEmail.isEmpty()) { // error handling in case say typo of empty table
            throw new IllegalArgumentException("client email name cannot be null or empty");
        }
        return clientRepository.showClient(clientEmail);
    }
*/
    public List<Client> showAllClients() {
        return clientRepository.showAllClients();
    }

    public void deleteClient(int clientId) {
        clientRepository.deleteClient(clientId);
    }




}
