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
        String query = "INSERT INTO client (client_company, client_email) VALUES (?, ?)";
        jdbcTemplate.update(client);
    }

    public void removeClient(long clientID ) throws SQLException {
        Connection conn = connect();
    }

    public void updateClient(Client client) throws SQLException {
        Connection conn = connect();
    }
    public Client readClient(String clientName, String clientEmail) throws SQLException {
        Client client = null;
        Connection conn = connect();

        return client;
    }
}
