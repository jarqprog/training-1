package com.ania.training.service.implementation;

import com.ania.training.applicationContext.impl.TestContext;
import com.ania.training.model.Student;
import com.ania.training.service.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.Set;

public class RetrievingStudentTest {

    private StudentService studentService;

    @Before
    public void init() {
        studentService = TestContext
                .getInstance()
                .getService(SimpleStudentService.class);
    }

    @Test
    public void retrievingNonExistingStudent_shouldReturnEmptyOptional() {

        long notExistingStudentId = 12;

        Optional<Student> optional = studentService.findOne(notExistingStudentId);

        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void retrievingNonExistingStudents_shouldReturnEmptySet() {

        Set<Student> students = studentService.findAll();

        Assert.assertTrue(students.isEmpty());
    }

    @Test
    public void retrievingExistingStudent_ifOneStudentInDB() {

        String name = "Ann";
        String surname = "Groszek";
        String email = "groszek@gmail.com";

        long id = studentService.create(name, surname, email).orElseThrow(RuntimeException::new).getId();
        Student ann = studentService.findOne(id).orElseThrow(RuntimeException::new);

        Assert.assertEquals(id, ann.getId());
        Assert.assertEquals(name, ann.getPerson().getName());
        Assert.assertEquals(surname, ann.getPerson().getSurname());
        Assert.assertEquals(email, ann.getPerson().getEmailAddress());
    }

    @Test
    public void retrievingExistingStudent_ifCoupleStudentsInDB() {

        String name = "Ann";
        String surname = "Groszek";
        String email = "groszek@gmail.com";

        long id = studentService.create(name, surname, email).orElseThrow(RuntimeException::new).getId();

        String[][] studentsData = {
                {"Rob", "Mahoney", "rob009@gmail.com"},
                {"Mark", "Vin", "marcus@gmail.com"},
                {"Peter", "Clark", "peter.clarc@gmail.com"}
        };

        for (String[] data : studentsData) {
            studentService.create(data[0], data[1], data[2]);
        }

        Student ann = studentService.findOne(id).orElseThrow(RuntimeException::new);

        Assert.assertEquals(id, ann.getId());
        Assert.assertEquals(name, ann.getPerson().getName());
        Assert.assertEquals(surname, ann.getPerson().getSurname());
        Assert.assertEquals(email, ann.getPerson().getEmailAddress());
    }

    @Test
    public void retrievingAllExistingStudents_ifCoupleStudentsInDB() {

        String[][] studentsData = {
                {"Rob", "Mahoney", "rob009@gmail.com"},
                {"Mark", "Vin", "marcus@gmail.com"},
                {"Peter", "Clark", "peter.clarc@gmail.com"},
                {"Jerry", "House", "jerrrrrryyy@gmail.com"},
                {"Funny", "Boy", "jerrrrrryyy@gmail.com"}
        };

        long[] ids = new long[studentsData.length];

        for (int i=0; i<studentsData.length; i++) {
            ids[i] = studentService.create(studentsData[i][0], studentsData[i][1], studentsData[i][2])
                    .orElseThrow(RuntimeException::new).getId();
        }
        Set<Student> students = studentService.findAll();

        Assert.assertEquals(studentsData.length, students.size());
        for (int i=0; i<ids.length; i++) {
            Student student = studentService.findOne(ids[i]).orElseThrow(RuntimeException::new);
            Assert.assertEquals(ids[i], student.getId());
            Assert.assertEquals(studentsData[i][0], student.getPerson().getName());
            Assert.assertEquals(studentsData[i][1], student.getPerson().getSurname());
            Assert.assertEquals(studentsData[i][2], student.getPerson().getEmailAddress());
        }
    }



}
