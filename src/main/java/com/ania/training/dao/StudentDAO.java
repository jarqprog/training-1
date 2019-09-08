package com.ania.training.dao;


import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Student;

import java.util.Optional;
import java.util.Set;

public interface StudentDAO {

    Student create(String name, String surname, String emailAddress);
    Set<Student> findAll();
    Optional<Student> findOne(long id);
    Set<Student> findAllByTeacher(long teacherId);
    Student update(Student student) throws NotFoundException;
    void remove(Student student) throws NotFoundException;
    
}
