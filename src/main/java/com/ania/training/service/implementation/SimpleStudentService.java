package com.ania.training.service.implementation;

import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.model.Student;
import com.ania.training.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SimpleStudentService implements StudentService {

    private final StudentDAO studentDAO;

    private static final Logger logger = LogManager.getLogger(SimpleStudentService.class);

    public SimpleStudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Optional<Student> create(String name, String surname, String emailAddress) {
        logger.info(String.format("Creating Student: %s %s, email: %s", name, surname, emailAddress));
        try {
            return Optional.of(studentDAO.create(name, surname, emailAddress));
        } catch (CreationException e) {
            logger.warn(e.getMessage() + "\n" + e.getCause().getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
        }
        return Optional.empty();
    }

    @Override
    public Set<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Optional<Student> findOne(long id) {
        return studentDAO.findOne(id);
    }

    @Override
    public Set<Student> findAllByTeacher(long teacherId) {
        return new HashSet<>();
    }

    @Override
    public Optional<Student> update(Student student) {
        return Optional.empty();
    }

    @Override
    public boolean remove(Student student) {
        return false;
    }
}
