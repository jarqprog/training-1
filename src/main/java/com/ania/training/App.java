package com.ania.training;

import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.dao.implementation.inMemory.InMemoryPersonalDataDAO;
import com.ania.training.model.PersonalData;


public class App {
    public static void main( String[] args ) {


        InMemoryPersonalDataDAO dao = new InMemoryPersonalDataDAO();
        dao.create("Ala", "Ilo", "asfgafsf@ahsg.pl");
        dao.create("Ala", "Ilo", "asfgafsf@ahsg.pl");
        dao.create("Ala", "Ilo", "asfgafsf@ahsg.pl");

        PersonalData pd = dao.create("Ala", "Ilo", "asfgafsf@ahsg.pl");



        System.out.println(pd);


        System.out.println(dao.findOne(5));

        System.out.println(dao.findOne(3));
        pd.setName("Ania");
        pd.setMobileNumber("+48 000 111 222");
//        pd.setId(100);
        try {
            System.out.println(dao.update(pd));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }


    }

}
