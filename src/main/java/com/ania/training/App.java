package com.ania.training;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.dao.implementation.inMemory.InMemoryPersonalDataDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryStudentDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryTeacherDAO;
import com.ania.training.model.PersonalData;
import com.ania.training.service.StudentService;
import com.ania.training.service.implementation.SimpleStudentService;


public class App {
    public static void main( String[] args ) {

        //todo will be done in factory
        PersonalDataDAO personalDataDAO = new InMemoryPersonalDataDAO();
        TeacherDAO teacherDao = new InMemoryTeacherDAO(personalDataDAO);
        StudentDAO studentDao = new InMemoryStudentDAO(teacherDao, personalDataDAO);
        StudentService studentService = new SimpleStudentService(studentDao);

        System.out.println(studentService.create("Ala", "Ilo", "asfgafsf@ahsg.pl"));
        System.out.println(studentService.create("Jarek", "Kucharczyk", "jarqprog@gmail.com"));

    }

}
