package org.example.foersteaarseksamen.repositories;


import org.example.foersteaarseksamen.models.Client;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class ClientRepository {

    private String url = System.getenv("url");
    private String user = System.getenv("username");
    private String password = System.getenv("password");

    // Establishing the database connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addClient(Client client) throws SQLException {

    }

    public void removeClient(long clientID ) throws SQLException {

    }

    public void updateClient(Client client) throws SQLException {

    }
    public Client readClient(String clientName, String clientEmail) throws SQLException {
        Client client = null;

        return client;
    }
}
