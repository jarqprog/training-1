package com.ania.training.service.implementation;

import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.Student;
import com.ania.training.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

public class SimpleStudentService implements StudentService {

    private final StudentDAO studentDAO;

    //todo inject email verification

    private static final Logger logger = LogManager.getLogger(SimpleStudentService.class);

    public static StudentService getInstance(StudentDAO studentDAO) {
        return new SimpleStudentService(studentDAO);
    }

    private SimpleStudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Optional<Student> create(String name, String surname, String emailAddress) {
        logger.info(String.format("Creating Student: %s %s, email: %s", name, surname, emailAddress));
        try {
            validateStringArgumentsNotEmpty("create", name, surname, emailAddress);
            //todo validate email
            return Optional.of(studentDAO.create(name, surname, emailAddress));
        } catch (IllegalArgumentException | CreationException e) {
            logger.warn(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
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
        return studentDAO.findAllByTeacher(teacherId);
    }

    @Override
    public Optional<Student> update(Student student) {
        logger.info(String.format("Updating student (id=%s) with data: ", student.getId()) + student);
        try {
            return Optional.of(studentDAO.update(student));
        } catch (NotFoundException e) {
            logger.error(e);
        }
        return Optional.empty();
    }

    @Override
    public boolean remove(Student student) {
        logger.info(String.format("Removing student (id=%s) with data: ", student.getId()) + student);
        try {
            studentDAO.remove(student);
            return true;
        } catch (NotFoundException e) {
            logger.error(e);
        }
        return false;
    }

    private void validateStringArgumentsNotEmpty(String methodName, String... args) throws IllegalArgumentException {
        for (String s : args) {
            if (StringUtils.isEmpty(s)) {
                throw new IllegalArgumentException(String.format("SimpleStudentService in method: %s " +
                        "found empty String argument", methodName));
            }
        }
    }
}
