package com.ania.training.model;

public interface PersonalData extends Identification {

    void setName(String name);
    String getName();
    void setSurname(String surname);
    String getSurname();
    void setEmailAddress(String emailAddress);
    String getEmailAddress();
    void setMobileNumber(String mobileNumber);
    String getMobileNumber();
    PersonalData copy();

}
