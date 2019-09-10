package com.ania.training.dao.exceptions;

import com.ania.training.model.Identification;

public class CreationException extends Exception {
        public <T extends Identification> CreationException(Class<T> clazz) {
            super(String.format("Creation %s object failed!", clazz.getSimpleName()));
        }

        public <T extends Identification> CreationException(Class<T> clazz, Exception root) {
            super(String.format("Creation %s object failed!", clazz.getSimpleName()), root);
        }
}
