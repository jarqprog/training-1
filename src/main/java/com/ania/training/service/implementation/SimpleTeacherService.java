package com.ania.training.service.implementation;

import com.ania.training.dao.TeacherDAO;
import com.ania.training.model.Teacher;
import com.ania.training.service.TeacherService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class SimpleTeacherService implements TeacherService {

    private final TeacherDAO teacherDAO;

    private static final Logger logger = LogManager.getLogger(SimpleTeacherService.class);

    public SimpleTeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public Optional<Teacher> create(String name, String surname, String emailAddress) {
        return Optional.empty();
    }

    @Override
    public Set<Teacher> findAll() {
        return new HashSet<>();
    }

    @Override
    public Optional<Teacher> findOne(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Teacher>  update(Teacher teacher) {
        return Optional.empty();
    }

    @Override
    public boolean remove(Teacher teacher) {
        return false;
    }
}
