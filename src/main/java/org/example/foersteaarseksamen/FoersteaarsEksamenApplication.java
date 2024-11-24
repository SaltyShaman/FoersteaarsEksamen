package org.example.foersteaarseksamen;
import org.example.foersteaarseksamen.repositories.ClientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoersteaarsEksamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoersteaarsEksamenApplication.class, args);

        // Retrieve the ClientRepository bean
        ClientRepository clientRepository 

        // Add a client
        String clientCompany = "Manual Test Company";
        String clientEmail = "manual@test.com";

        clientRepository.addClient(clientCompany, clientEmail);

        // Confirm the operation
        System.out.println("Client added: " + clientCompany + " - " + clientEmail);
    }

}
