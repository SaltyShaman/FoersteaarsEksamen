package org.example.foersteaarseksamen.models;

public class Client {
    private long clientID;
    private String clientCompany;
    private String clientEmail;

    public Client(String clientCompany, String clientEmail) {
        this.clientCompany = clientCompany;
        this.clientEmail = clientEmail;
    }

    public Client() {
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientEmail='" + clientEmail + '\'' +
                ", clientCompany='" + clientCompany + '\'' +
                '}';
    }
}

