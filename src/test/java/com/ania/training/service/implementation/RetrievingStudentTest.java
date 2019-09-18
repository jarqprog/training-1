package com.ania.training.service.implementation;

import com.ania.training.applicationContext.impl.DevContext;
import com.ania.training.service.StudentService;
import org.junit.Before;

public class RetrievingStudentTest {

    private StudentService studentService;

    @Before
    public void init() {
        studentService = DevContext
                .getDevContext()
                .getService(SimpleStudentService.class);
    }
}
