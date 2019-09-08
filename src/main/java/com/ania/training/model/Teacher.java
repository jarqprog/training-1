package com.ania.training.model;

public class Teacher extends SimpleIdentification {

    private final PersonalData person;

    public Teacher(PersonalData person) {
        this.person = person;
    }

    public PersonalData getPerson() {
        return person;
    }
}
