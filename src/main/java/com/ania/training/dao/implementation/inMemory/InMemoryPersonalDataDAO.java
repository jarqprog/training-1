package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.exceptions.CreationException;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.SimplePersonalData;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryPersonalDataDAO implements PersonalDataDAO {

    private final Set<PersonalData> personalDataSet = new HashSet<>();
    private static long lastUsedId = 0;

    @Override
    public PersonalData create(String name, String surname, String emailAddress) throws CreationException {

        try {
            PersonalData personalData = new SimplePersonalData(name, surname, emailAddress);
            personalData.setId(++lastUsedId);
            personalDataSet.add(personalData);
            return personalData.copy();
        } catch (Exception e) {
            throw new CreationException(PersonalData.class, e);
        }
    }
;
    @Override
    public Optional<PersonalData> findOne(long id) {
        Optional<PersonalData> personalData = personalDataSet.stream().filter(p -> id == p.getId()).findFirst();
        return personalData.map(PersonalData::copy);
    }

    @Override
    public PersonalData update(PersonalData personalData) throws NotFoundException {
        validateIfContains(personalData);
        PersonalData current = findOne(personalData.getId())
                .orElseThrow(() -> new NotFoundException(SimplePersonalData.class, personalData.getId()));
        current.setName(personalData.getName());
        current.setSurname(personalData.getSurname());
        current.setEmailAddress(personalData.getEmailAddress());
        current.setMobileNumber(personalData.getMobileNumber());
        return current.copy();
    }

    @Override
    public void remove(PersonalData personalData) throws NotFoundException {
        validateIfContains(personalData);
        personalDataSet.remove(personalData);
    }

    private void validateIfContains(PersonalData personalData) throws NotFoundException {
        if (personalData == null || !personalDataSet.contains(personalData)) {
            throw new NotFoundException(SimplePersonalData.class, personalData == null ? -1 : personalData.getId());
        }
    }
}
