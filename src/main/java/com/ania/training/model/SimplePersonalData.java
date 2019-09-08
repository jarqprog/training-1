package com.ania.training.model;


public class SimplePersonalData extends SimpleIdentification {

    private String name;
    private String surname;
    private String emailAddress;
    private String mobileNumber;

    public SimplePersonalData() {
        this.mobileNumber = "";
    }

    public SimplePersonalData(String name, String surname, String emailAddress) {
        this();
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
