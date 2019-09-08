package com.ania.training.model;

public abstract class SimpleIdentification implements Identification {

    private long id;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}
