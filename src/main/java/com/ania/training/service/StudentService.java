package com.ania.training.service;

import com.ania.training.model.Student;

import java.util.Optional;
import java.util.Set;

public interface StudentService extends Service {

    Optional<Student> create(String name, String surname, String emailAddress);
    Set<Student> findAll();
    Optional<Student> findOne(long id);
    Set<Student> findAllByTeacher(long teacherId);
    Optional<Student> update(Student student);
    boolean remove(Student student);

}
