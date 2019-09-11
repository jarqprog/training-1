package com.ania.training.model;


import java.util.Objects;

public class SimplePersonalData extends SimpleIdentification implements PersonalData {

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

    @Override
    public String toString() {
        return "SimplePersonalData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimplePersonalData that = (SimplePersonalData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(mobileNumber, that.mobileNumber);
    }

    @Override
    public PersonalData copy() {
        PersonalData copy = new SimplePersonalData();
        copy.setId(getId());
        copy.setName(getName());
        copy.setSurname(getSurname());
        copy.setEmailAddress(getEmailAddress());
        copy.setMobileNumber(getMobileNumber());
        return copy;
    }
}
