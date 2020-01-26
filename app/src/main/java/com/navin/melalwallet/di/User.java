package com.navin.melalwallet.di;

import javax.inject.Inject;

public class User {

    Contact contact;

    @Inject
    public User(Contact contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        contact.setEmail(email);
    }

    public String getEmailAccount() {
        return contact.getEmail();
    }

    public void clear() {
        contact.deleteEmail();
    }


}
