package com.ania.training.applicationContext;


import com.ania.training.service.Service;

public interface Context {

    <T extends Service> T getService(Class<T> clazz);

}
