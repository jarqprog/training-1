package com.ania.training.applicationContext.impl;

import com.ania.training.applicationContext.Context;
import com.ania.training.applicationContext.ContextException;
import com.ania.training.dao.PersonalDataDAO;
import com.ania.training.dao.StudentDAO;
import com.ania.training.dao.TeacherDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryPersonalDataDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryStudentDAO;
import com.ania.training.dao.implementation.inMemory.InMemoryTeacherDAO;
import com.ania.training.service.Service;
import com.ania.training.service.StudentService;
import com.ania.training.service.TeacherService;
import com.ania.training.service.implementation.SimpleStudentService;
import com.ania.training.service.implementation.SimpleTeacherService;

public class TestContext implements Context {

    private static Context instance;

    public static Context getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    private TestContext() {}

    @Override
    public <T extends Service> T getService(Class<T> clazz) {

        Service service;
        final String serviceName = clazz.getSimpleName();

        switch (serviceName) {
            case "SimpleStudentService":
                service = getStudentService();
                break;
            case "SimpleTeacherService":
                service = getTeacherService();
                break;
            default:
                throw new ContextException(clazz);
        }

        @SuppressWarnings("unchecked") T output = (T) service;
        return output;
    }

    private static PersonalDataDAO getPersonalDataDAO() {
        return new InMemoryPersonalDataDAO();
    }

    private static TeacherDAO getTeacherDAO() {
        return new InMemoryTeacherDAO(getPersonalDataDAO());
    }

    private static StudentDAO getStudentDAO() {
        return new InMemoryStudentDAO(getTeacherDAO(), getPersonalDataDAO());
    }

    private static TeacherService getTeacherService() {
        return new SimpleTeacherService(getTeacherDAO());
    }

    private static StudentService getStudentService() {
        return SimpleStudentService.getInstance(getStudentDAO());
    }
}
