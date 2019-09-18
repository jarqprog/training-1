package com.ania.training.applicationContext;

public class ContextException extends RuntimeException {

    public ContextException(Class clazz) {
        super(String.format("Cannot retrieve object: %s", clazz.getSimpleName()));
    }
}
