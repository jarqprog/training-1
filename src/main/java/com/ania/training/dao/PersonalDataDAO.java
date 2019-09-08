package com.ania.training.dao;

import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;

import java.util.Optional;

public interface PersonalDataDAO {

    PersonalData create(String name, String surname, String emailAddress);
    Optional<PersonalData> findOne(long id);
    PersonalData update(PersonalData personalData) throws NotFoundException;
    void remove(PersonalData personalData) throws NotFoundException;

}
