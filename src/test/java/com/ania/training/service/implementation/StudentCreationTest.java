package com.ania.training.service.implementation;

import com.ania.training.applicationContext.impl.TestContext;
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
        studentService = TestContext
                .getInstance()
                .getService(SimpleStudentService.class);
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