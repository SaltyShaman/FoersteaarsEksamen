package org.example.foersteaarseksamen.repositories;

import org.example.foersteaarseksamen.models.Client;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    //create
    public void addClient(String clientCompany, String clientEmail, String clientName) {
        String query = "INSERT INTO `client`(client_company, client_email, client_name) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, clientCompany, clientEmail, clientName);
    }


    //Read all clients
    public List<Client> showAllClients() {
        String query = "SELECT * FROM `client`";
        RowMapper rowMapper1 = new BeanPropertyRowMapper(Client.class);
        return jdbcTemplate.query(query, rowMapper1);
    }
    /*
    //Read one client- Don't know if this method is necessary.
    public Client showClient(String clientEmail) {
        String query = "SELECT * FROM client WHERE client_email = ?";
        try {
            return jdbcTemplate.queryForObject(query, rowMapper, clientEmail);
        } catch (EmptyResultDataAccessException e) {
            return null; // return null if no project found
        }

    }
*/
    //Update client
    public void updateClient(String clientCompany, String clientName, String clientEmail, String oldClientEmail) {
        String query = "UPDATE `client` SET client_company = ?, client_name = ?, client_email = ? WHERE client_email = ?";
        jdbcTemplate.update(query, clientCompany, clientName, clientEmail, oldClientEmail);
    }


    //Delete client
    public void deleteClient(int client_id) {
        String query = "DELETE FROM `client` WHERE client_id = ?";
        System.out.println("Executing DELETE query for client_id: " + client_id);
        jdbcTemplate.update(query, client_id);
    }


}
