package com.navin.melalwallet.di;

public class Contact {

    private String email;


    public Contact() {

    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void deleteEmail() {
        email = "";
    }

}
