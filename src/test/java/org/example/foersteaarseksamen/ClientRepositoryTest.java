package org.example.foersteaarseksamen;

import org.example.foersteaarseksamen.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        // Optional setup before each test
    }

    @Test
    public void testAddClient() {
        // Arrange
        String clientName = "Acme Corp";
        String clientEmail = "acme@corp.com";

        // Act
        clientRepository.addClient(clientName, clientEmail);

        // Assert
        // Use JdbcTemplate to verify data is correctly added
        String query = "SELECT COUNT(*) FROM client WHERE client_company = ? AND client_email = ?";
        Integer count = jdbcTemplate.queryForObject(query, Integer.class, clientName, clientEmail);

        assertEquals(1, count);
    }

    @Test
    public void testRemoveClient() {
        // Similar to above: add a client, then remove, and verify.
    }
}
