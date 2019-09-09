package com.ania.training.service.implementation;

import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Teacher;
import com.ania.training.service.TeacherService;

import java.util.Set;

public class SimpleTeacherService implements TeacherService {




    @Override
    public Teacher create(String name, String surname, String emailAddress) {
        return null;
    }

    @Override
    public Set<Teacher> findAll() {
        return null;
    }

    @Override
    public Teacher findOne(long id) throws NotFoundException {
        return null;
    }

    @Override
    public Teacher update(Teacher teacher) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Teacher teacher) throws NotFoundException {

    }
}
