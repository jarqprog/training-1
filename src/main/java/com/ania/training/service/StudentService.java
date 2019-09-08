package com.ania.training.service;

import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Student;

import java.util.Set;

public interface StudentService {

    Student create(String name, String surname, String emailAddress);
    Set<Student> findAll();
    Student findOne(long id) throws NotFoundException;
    Set<Student> findAllByTeacher(long teacherId);
    Student update(Student student) throws NotFoundException;
    void remove(Student student) throws NotFoundException;

}
