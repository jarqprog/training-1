package com.ania.training.dao.exceptions;

import com.ania.training.model.Identification;

public class NotFoundException extends Exception {

    public <T extends Identification> NotFoundException(Class<T> clazz, long id) {
        super(String.format("Object of %s with id=%s not found!", clazz.getSimpleName(), id));

    }
}
