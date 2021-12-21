package com.example.javafx.ContactModified;


public class ContactModified {
    private String firstName;
    private String lastName;
    private String email;
    private String phoNumber;
    private String image;

    public ContactModified(){}

    public ContactModified(String firstName, String lastName, String email, String phoNumber, String image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoNumber = phoNumber;
        this.image = image;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoNumber() {
        return phoNumber;
    }

    public void setPhoNumber(String phoNumber) {
        this.phoNumber = phoNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return lastName;
    }
}
