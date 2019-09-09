package com.ania.training.model;

import java.util.Objects;

public class Student extends SimpleIdentification {

    private final PersonalData person;
    private Teacher teacher;


    public Student(PersonalData person) {
        this.person = person;
    }

    public Student(Student student) {
        this.person = student.getPerson();
        this.teacher = student.getTeacher();
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

    @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", teacher=" + teacher +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return getPerson().equals(student.getPerson());
    }
}
