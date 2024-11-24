package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Client> rowMapper = (rs, rowNum) -> new Client(
            rs.getString("client_company"),
            rs.getString("client_email")
    );

    //create
    public void addClient(@NotNull Client client) {
        String query = "INSERT INTO client(client_company, client_email) VALUES (?, ?)";
        jdbcTemplate.update(query, client.getClientCompany(), client.getClientEmail());
    }

    //Read all
    public List<Client> showClients() {
        String query = "SELECT * FROM client";
        return jdbcTemplate.query(query, rowMapper);
    }

    //Update
    public void updateClient(@NotNull Client client) {
        String query = "UPDATE client SET client_company = ?, client_email = ? WHERE client_id = ?";
        jdbcTemplate.update(query, client.getClientCompany(), client.getClientEmail());
    }

    //Delete
    public void removeClient(Client client) {

    }
}
