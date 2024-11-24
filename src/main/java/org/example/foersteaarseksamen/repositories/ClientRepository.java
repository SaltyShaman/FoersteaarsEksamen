package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository {

    private JdbcTemplate template;

    public ClientRepository(JdbcTemplate template) {
        this.template = template;
    }


    public void addClient(String clientCompany, String clientEmail) {
        String query = "INSERT INTO client(client_company, client_email) VALUES (?, ?)";
        template.update(query, clientCompany, clientEmail);
    }

    public void removeClient(Client client) {

    }

    public void updateClient(Client client) {

    }
    public Client readClient(String clientName, String clientEmail) {
        Client client = null;


        return client;
    }
}
