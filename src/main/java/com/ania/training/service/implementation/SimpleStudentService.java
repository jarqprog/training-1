package com.ania.training.service.implementation;

import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Student;
import com.ania.training.service.StudentService;

import java.util.Set;

public class SimpleStudentService implements StudentService {

    private final StudentDAO studentDAO;

    public SimpleStudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student create(String name, String surname, String emailAddress) {
        return studentDAO.create(name, surname, emailAddress);
    }

    @Override
    public Set<Student> findAll() {
        return null;
    }

    @Override
    public Student findOne(long id) throws NotFoundException {
        return null;
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
