package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Teacher;

import java.util.Optional;
import java.util.Set;

public class InMemoryTeacherDAO implements TeacherDAO {
    @Override
    public Teacher create(String name, String surname, String emailAddress) {
        return null;
    }

    @Override
    public Set<Teacher> findAll() {
        return null;
    }

    @Override
    public Optional<Teacher> findOne(long id) {
        return Optional.empty();
    }

    @Override
    public Teacher update(Teacher teacher) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Teacher teacher) throws NotFoundException {

    }
}
