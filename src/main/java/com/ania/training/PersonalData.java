package com.ania.training;

public class PersonalData implements PersonalDataInterface{
    private String name;
    private String surname;
    private String emailAddress;
    private int mobileNumber;

    public PersonalData(String name, String surname, String emailAddress, int mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
    }


    @Override
    public String setName() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String setSurname() {
        return null;
    }

    @Override
    public String getSurname() {
        return null;
    }

    @Override
    public String setEmailAddress() {
        return null;
    }

    @Override
    public String getEmailAddress() {
        return null;
    }

    @Override
    public int setMobileNumber() {
        return 0;
    }

    @Override
    public int getMobileNumber() {
        return 0;
    }
}
