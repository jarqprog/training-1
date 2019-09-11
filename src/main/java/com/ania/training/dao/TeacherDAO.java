package com.ania.training.dao;


import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Teacher;
import java.util.Optional;
import java.util.Set;

public interface TeacherDAO {
    Teacher create(String name, String surname, String emailAddress) throws CreationException;
    Set<Teacher> findAll();
    Optional<Teacher> findOne(long id);
    Teacher update(Teacher teacher) throws NotFoundException;
    void remove(Teacher teacher) throws NotFoundException;
}
