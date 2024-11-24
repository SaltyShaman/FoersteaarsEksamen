package org.example.foersteaarseksamen.models;

public class Client {
    private long clientID;
    private String clientCompany;
    private String clientEmail;
    private String clientName;

    public Client(String clientCompany, String clientEmail, String clientName) {
        this.clientCompany = clientCompany;
        this.clientEmail = clientEmail;
        this.clientName = clientName;
    }

    public Client() {
    }

    public long getClientID() {
        return clientID;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
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

