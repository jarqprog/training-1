package com.ania.training;

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


        InMemoryPersonalDataDAO personalDataDAO = new InMemoryPersonalDataDAO();
        personalDataDAO.create("Ala", "Ilo", "asfgafsf@ahsg.pl");
        personalDataDAO.create("Ala", "Ilo", "asfgafsf@ahsg.pl");
        personalDataDAO.create("Ala", "Ilo", "asfgafsf@ahsg.pl");

        PersonalData pd = personalDataDAO.create("Ala", "Ilo", "asfgafsf@ahsg.pl");



        System.out.println(pd);


        System.out.println(personalDataDAO.findOne(5));

        System.out.println(personalDataDAO.findOne(3));
        pd.setName("Ania");
        pd.setMobileNumber("+48 000 111 222");
//        pd.setId(100);
        try {
            System.out.println(personalDataDAO.update(pd));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        TeacherDAO teacherDao = new InMemoryTeacherDAO(personalDataDAO);
        StudentDAO studentDao = new InMemoryStudentDAO(teacherDao, personalDataDAO);
        StudentService studentService = new SimpleStudentService(studentDao);
        studentService.create("Jarek", "Kucharczyk", "jarqprog@gmail.com");


    }

}
