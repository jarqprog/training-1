package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.SimplePersonalData;
import com.ania.training.model.Student;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InMemoryStudentDAO implements StudentDAO {

    private final Set<Student> students = new HashSet<>();
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
            return student.copy();
        } catch (Exception e) {
            throw new CreationException(Student.class, e);
        }
    }

    @Override
    public Set<Student> findAll() {
        return students.stream()
                .map(Student::copy)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<Student> findOne(long id) {
        Optional<Student> student = students.stream().filter(p -> id == p.getId()).findFirst();
        return student.map(Student::copy);
    }

    @Override
    public Set<Student> findAllByTeacher(long teacherId) {
        return students.stream()
                .filter(s -> s.getTeacher() != null && s.getTeacher().getId() == teacherId)
                .map(Student::copy)
                .collect(Collectors.toSet());
    }

    @Override
    public Student update(Student student) throws NotFoundException {
        validateIfContains(student);
        Student current = findOne(student.getId())
                .orElseThrow(() -> new NotFoundException(SimplePersonalData.class, student.getId()));
        personalDataDAO.update(student.getPerson());
        teacherDAO.update(student.getTeacher());
        current.setTeacher(student.getTeacher());
        return current.copy();
    }

    @Override
    public void remove(Student student) throws NotFoundException {
        validateIfContains(student);
        students.remove(student);
    }

    private void validateIfContains(Student student) throws NotFoundException {
        if (student == null || !students.contains(student)) {
            throw new NotFoundException(Student.class, student == null ? -1 : student.getId());
        }
    }
}
