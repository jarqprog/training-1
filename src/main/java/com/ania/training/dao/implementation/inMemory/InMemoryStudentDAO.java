package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Student;

import java.util.Optional;
import java.util.Set;

public class InMemoryStudentDAO implements StudentDAO {
    @Override
    public Student create(String name, String surname, String emailAddress) {
        return null;
    }

    @Override
    public Set<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> findOne(long id) {
        return Optional.empty();
    }

    @Override
    public Set<Student> findAllByTeacher(long teacherId) {
        return null;
    }

    @Override
    public Student update(Student student) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Student student) throws NotFoundException {

    }
}
