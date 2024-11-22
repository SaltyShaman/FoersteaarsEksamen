package org.example.foersteaarseksamen.models;

public class Client {
    private long clientID;
    private String clientName;
    private String clientEmail;

    public Client(long clientID, String clientName, String clientEmail) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public long getClientID() {
        return clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientID(long clientID) {
        this.clientID = clientID;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", clientName='" + clientName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                '}';
    }
}

