package org.example.foersteaarseksamen.models;

public class Client {
    private int client_id;
    private String clientCompany;
    private String clientEmail;
    private String clientName;

    public Client() {
    }

    public Client(int client_id, String clientCompany, String clientEmail, String clientName) {
        this.client_id = client_id;
        this.clientCompany = clientCompany;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
    }



    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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

