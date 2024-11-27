package org.example.foersteaarseksamen.models;

public class Client {
    private int clientId;
    private String clientCompany;
    private String clientEmail;
    private String clientName;

    public Client(int clientId, String clientCompany, String clientEmail, String clientName) {
        this.clientId = clientId;
        this.clientCompany = clientCompany;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
    }

    public Client() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientID(int clientId) {
        this.clientId = clientId;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientCompany(String clientCompany) {
        this.clientCompany = clientCompany;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}

