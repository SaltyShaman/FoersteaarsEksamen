package org.example.foersteaarseksamen.models;

public class Client {
    private long clientID;
    private String clientCompany;
    private String clientEmail;

    public Client(long clientID, String clientCompany, String clientEmail) {
        this.clientID = clientID;
        this.clientCompany = clientCompany;
        this.clientEmail = clientEmail;
    }

    public long getClientID() {
        return clientID;
    }

    public String getClientCompany() {
        return clientCompany;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
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
                "clientID=" + clientID +
                ", clientCompany='" + clientCompany + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}

