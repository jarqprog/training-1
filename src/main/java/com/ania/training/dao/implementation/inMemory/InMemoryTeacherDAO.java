package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.Teacher;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryTeacherDAO implements TeacherDAO {

    private final Set<Teacher> teachers = new HashSet<>();
    private final Gson gson = new Gson();
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
            return gson.fromJson(gson.toJson(teacher), Teacher.class);
        } catch (Exception e) {
            throw new CreationException(Teacher.class, e);
        }
    }

    @Override
    public Set<Teacher> findAll() {
        return null;
    }

    @Override
    public Optional<Teacher> findOne(long id) {
        return teachers.stream().filter(p -> id == p.getId()).findFirst();
    }

    @Override
    public Teacher update(Teacher teacher) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Teacher teacher) throws NotFoundException {

    }
}
