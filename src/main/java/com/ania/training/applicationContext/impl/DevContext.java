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

public class DevContext implements Context {

    private static Context instance;
    private static PersonalDataDAO personalDataDAO;
    private static StudentDAO studentDAO;
    private static TeacherDAO teacherDAO;
    private static StudentService studentService;
    private static TeacherService teacherService;

    public static Context getDevContext() {
        if (instance == null) {
            instance = new DevContext();
        }
        return instance;
    }

    private DevContext() {}

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
        if (personalDataDAO == null) {
            personalDataDAO = new InMemoryPersonalDataDAO();
        }
        return personalDataDAO;
    }

    private static TeacherDAO getTeacherDAO() {
        if (teacherDAO == null) {
            teacherDAO = new InMemoryTeacherDAO(getPersonalDataDAO());
        }
        return teacherDAO;
    }

    private static StudentDAO getStudentDAO() {
        if (studentDAO == null) {
            studentDAO = new InMemoryStudentDAO(getTeacherDAO(), getPersonalDataDAO());
        }
        return studentDAO;
    }

    private static TeacherService getTeacherService() {
        if (teacherService == null) {
            teacherService = new SimpleTeacherService(getTeacherDAO());
        }
        return teacherService;
    }

    private static StudentService getStudentService() {
        if (studentService == null) {
            studentService = SimpleStudentService.getInstance(getStudentDAO());
        }
        return studentService;
    }
}
