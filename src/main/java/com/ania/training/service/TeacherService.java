package com.ania.training.service;

import com.ania.training.model.Teacher;

import java.util.Optional;
import java.util.Set;

public interface TeacherService extends Service {

    Optional<Teacher> create(String name, String surname, String emailAddress);
    Set<Teacher> findAll();
    Optional<Teacher>  findOne(long id);
    Optional<Teacher>  update(Teacher teacher);
    boolean remove(Teacher teacher);

}
