package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Client;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Repository
public class ClientRepository {

    private String url = System.getenv("url");
    private String user = System.getenv("username");
    private String password = System.getenv("password");

    private JdbcTemplate template;

    public ClientRepository(JdbcTemplate template) {
        this.template = template;
    }

    // Establishing the database connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addClient(String clientName, String clientEmail ){
        String query = "INSERT INTO client (client_company, client_email) VALUES (?, ?)";
        template.update(query, clientName, clientEmail);
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
