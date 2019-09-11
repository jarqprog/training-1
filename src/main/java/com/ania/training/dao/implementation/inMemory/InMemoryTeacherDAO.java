package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryTeacherDAO implements TeacherDAO {

    private final Set<Teacher> teachers = new HashSet<>();
    private final PersonalDataDAO personalDataDAO;
    private static long lastUsedId = 0;

    public InMemoryTeacherDAO(PersonalDataDAO personalDataDAO) {
        this.personalDataDAO = personalDataDAO;
    }

    @Override
    public Teacher create(String name, String surname, String emailAddress) throws CreationException {
        try {
            PersonalData personalData = personalDataDAO.create(name, surname, emailAddress);
            Teacher teacher = new Teacher(personalData);
            teacher.setId(++lastUsedId);
            teachers.add(teacher);
            return teacher.copy();
        } catch (Exception e) {
            throw new CreationException(Teacher.class, e);
        }
    }

    @Override
    public Set<Teacher> findAll() {
       return teachers.stream()
               .map(Teacher::copy)
               .collect(Collectors.toSet());
    }

    @Override
    public Optional<Teacher> findOne(long teacherId) {
        Optional<Teacher> teacher = teachers.stream()
                .filter(p -> teacherId == p.getId())
                .findFirst();
        return teacher.map(Teacher::copy);
    }

    @Override
    public Teacher update(Teacher teacher) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Teacher teacher) throws NotFoundException {

    }

    private void validateIfContains(Teacher teacher) throws NotFoundException {
        if (teacher == null || !teachers.contains(teacher)) {
            throw new NotFoundException(Teacher.class, teacher == null ? -1 : teacher.getId());
        }
    }
}
