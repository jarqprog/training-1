package com.ania.training.model;

public class Student extends SimpleIdentification {

    private final PersonalData person;
    private Teacher teacher;


    public Student(PersonalData person) {
        this.person = person;
    }


    public PersonalData getPerson() {
        return person;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
