package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ClientRepository clientRepository;


    @BeforeEach
    public void setup() {
        // Optional setup before each test
    }

    @Test
    void testDatabaseConnection() {
        String url = System.getenv("url");
        String username = System.getenv("username");
        String password = System.getenv("password");

        if (url == null || username == null || password == null) {
            fail("Environment variables are not set correctly.");
        }

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            assertNotNull(connection);
            System.out.println("Connection successful!");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Connection failed: " + e.getMessage());
        }
    }

    @org.junit.Test
    public void testAddClient() {
        // Arrange
        String clientName = "Acme Corp";
        String clientEmail = "acme@corp.com";

        String query = "INSERT INTO client (client_company, client_email) VALUES (?, ?)";
        Mockito.doNothing().when(jdbcTemplate).update(query, clientName, clientEmail);

        // Act
        clientRepository.addClient();

        // Assert
        Mockito.verify(jdbcTemplate).update(query, clientName, clientEmail);
    }
}

    @Test
    public void testRemoveClient() {
        // Similar to above: add a client, then remove, and verify.
    }
}
