package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testAddClientToLiveDatabase() {
        // Arrange
        String clientCompany = "Live Test Company";
        String clientEmail = "live@test.com";

        // Act
        clientRepository.addClient(clientCompany, clientEmail);

        // Assert
        System.out.println("Client added to the live database: " + clientCompany + ", " + clientEmail);
    }

    @Test
    public void testRemoveClient() {
        // Similar to above: add a client, then remove, and verify.
    }
}
