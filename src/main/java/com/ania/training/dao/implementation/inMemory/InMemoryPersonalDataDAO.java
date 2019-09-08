package com.ania.training.dao.implementation.inMemory;

import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.exceptions.NotFoundException;
import com.ania.training.model.PersonalData;
import com.ania.training.model.SimplePersonalData;
import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class InMemoryPersonalDataDAO implements PersonalDataDAO {

    private final Set<PersonalData> personalDataSet = new HashSet<>();
    private final Gson gson = new Gson();
    private static long lastUsedId = 0;

    @Override
    public PersonalData create(String name, String surname, String emailAddress) {
        PersonalData personalData = new SimplePersonalData(name, surname, emailAddress);
        personalData.setId(++lastUsedId);
        personalDataSet.add(personalData);
        return gson.fromJson(gson.toJson(personalData), SimplePersonalData.class);
    }

    @Override
    public Optional<PersonalData> findOne(long id) {
        return personalDataSet.stream().filter(p -> id == p.getId()).findFirst();
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
        return gson.fromJson(gson.toJson(current), SimplePersonalData.class);
    }

    @Override
    public void remove(PersonalData personalData) throws NotFoundException {
        validateIfContains(personalData);
        personalDataSet.remove(personalData);
    }

    private void validateIfContains(PersonalData personalData) throws NotFoundException {
        if (! personalDataSet.contains(personalData)) {
            throw new NotFoundException(SimplePersonalData.class, personalData.getId());
        }
    }
}
