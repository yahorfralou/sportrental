package com.epam.javadev.sportsrental.dao.fs.reader.exception;

/**
 * Created by Yahor_Fralou on 6/27/2017.
 */
public class EntityResolveException extends Exception {
    public EntityResolveException() {
        super();
    }

    public EntityResolveException(String message) {
        super(message);
    }

    public EntityResolveException(String message, Throwable cause) {
        super(message, cause);
    }
}
