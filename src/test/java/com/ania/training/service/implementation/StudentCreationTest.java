package com.ania.training.service.implementation;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryPersonalDataDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryStudentDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryTeacherDAO;
import com.ania.training.model.Student;
import com.ania.training.service.StudentService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class StudentCreationTest {

    private StudentService studentService;

    @Before
    public void init() {
        PersonalDataDAO personalDataDAO = new InMemoryPersonalDataDAO();
        TeacherDAO teacherDAO = new InMemoryTeacherDAO(personalDataDAO);
        StudentDAO studentDAO = new InMemoryStudentDAO(teacherDAO, personalDataDAO);
        studentService = SimpleStudentService.getInstance(studentDAO);
    }

    @Test
    public void shouldNotCreateStudentUsingInvalidArgument_NameIsEmptyString() {
        //given
        String name = "";
        String surname = "Groszek";
        String email = "groszek@gmail.com";

        //when
        Optional<Student> result = studentService.create(name, surname, email);

        //then
        assertFalse(result.isPresent());
    }

    @Test
    public void shouldNotCreateStudentUsingInvalidArgument_EmailIsNull() {
        //given
        String name = "Ann";
        String surname = "Groszek";
        String email = null;

        //when
        Optional<Student> result = studentService.create(name, surname, email);

        //then
        assertFalse(result.isPresent());
    }

    @Test
    public void shouldCreateStudent_CorrectArguments() {
        //given
        String name = "Ann";
        String surname = "Groszek";
        String email = "groszek@gmail.com";

        //when
        Optional<Student> result = studentService.create(name, surname, email);

        //then
        assertTrue(result.isPresent());
    }

    @Test
    public void checkIfStudentPersonalDataCreatedCorrectly() {
        //given
        String name = "Ann";
        String surname = "Groszek";
        String email = "groszek@gmail.com";

        //when
        Optional<Student> result = studentService.create(name, surname, email);

        //then
        assertTrue(result.isPresent());

        Student student = result.get();

        assertEquals(name, student.getPerson().getName());
        assertEquals(surname, student.getPerson().getSurname());
        assertEquals(email, student.getPerson().getEmailAddress());
    }



}