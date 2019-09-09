package com.ania.training.service;

import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Teacher;

import java.util.Set;

public interface TeacherService {

    Teacher create(String name, String surname, String emailAddress);
    Set<Teacher> findAll();
    Teacher findOne(long id) throws NotFoundException;
    Teacher update(Teacher teacher) throws NotFoundException;
    void remove(Teacher teacher) throws NotFoundException;

}
