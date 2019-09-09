package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.Student;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryStudentDAO implements StudentDAO {

    private final Set<Student> students = new HashSet<>();
    private final Gson gson = new Gson();
    private final TeacherDAO teacherDAO;
    private final PersonalDataDAO personalDataDAO;

    public InMemoryStudentDAO(TeacherDAO teacherDAO, PersonalDataDAO personalDataDAO) {
        this.teacherDAO = teacherDAO;
        this.personalDataDAO = personalDataDAO;
    }

    @Override
    public Student create(String name, String surname, String emailAddress) {
        PersonalData personalData = personalDataDAO.create(name, surname, emailAddress);
        Student student = new Student(personalData);
        //id

        return null;
    }

    @Override
    public Set<Student> findAll() {
        return new HashSet<>();
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
