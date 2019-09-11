package com.ania.training.model;

import java.util.Objects;

public class Teacher extends SimpleIdentification {

    private final PersonalData person;

    public Teacher(PersonalData person) {
        this.person = person;
    }

    public PersonalData getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "person=" + person +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getPerson(), teacher.getPerson());
    }

    public Teacher copy() {
        Teacher copy = new Teacher(person.copy());
        copy.setId(getId());
        return copy;
    }
}
