package org.example.foersteaarseksamen.models;

public class Client {
    private long ID;
    private String clientName;
    private String clientEmail;

    public Client(long ID, String clientName, String clientEmail) {
        this.ID = ID;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public long getID() {
        return ID;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    //might need to string method similar to User in wishlist
}

