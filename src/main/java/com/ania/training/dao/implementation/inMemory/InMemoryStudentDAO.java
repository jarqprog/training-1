package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.Student;
import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryStudentDAO implements StudentDAO {

    private final Set<Student> students = new HashSet<>();
    private final Gson gson = new Gson();
    private final TeacherDAO teacherDAO;
    private final PersonalDataDAO personalDataDAO;
    private static long lastUsedId = 0;


    public InMemoryStudentDAO(TeacherDAO teacherDAO, PersonalDataDAO personalDataDAO) {
        this.teacherDAO = teacherDAO;
        this.personalDataDAO = personalDataDAO;
    }

    @Override
    public Student create(String name, String surname, String emailAddress) throws CreationException {
        try {
            PersonalData personalData = personalDataDAO.create(name, surname, emailAddress);
            Student student = new Student(personalData);
            student.setId(++lastUsedId);
            students.add(student);
            return gson.fromJson(gson.toJson(student), Student.class);//todo need to resolve issue with handling nested object
        } catch (Exception e) {
            throw new CreationException(Student.class, e);
        }
    }

    @Override
    public Set<Student> findAll() {
        return students.stream()
                .map(s -> gson.fromJson(gson.toJson(s), Student.class))
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Student> findOne(long id) {
        Optional<Student> student = students.stream().filter(p -> id == p.getId()).findFirst();
        return student.map(data -> gson.fromJson(gson.toJson(data), Student.class));
    }

    @Override
    public Set<Student> findAllByTeacher(long teacherId) {
        return new HashSet<>();
    }

    @Override
    public Student update(Student student) throws NotFoundException {
        return null;
    }

    @Override
    public void remove(Student student) throws NotFoundException {

    }
}
