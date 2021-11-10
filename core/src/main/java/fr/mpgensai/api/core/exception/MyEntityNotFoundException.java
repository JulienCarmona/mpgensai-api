package fr.mpgensai.api.core.exception;

import java.util.function.Supplier;

public class MyEntityNotFoundException extends RuntimeException {

    public MyEntityNotFoundException() {
        super();
    }

    public MyEntityNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MyEntityNotFoundException(final String message) {
        super(message);
    }

    public MyEntityNotFoundException(final Throwable cause) {
        super(cause);
    }

    public MyEntityNotFoundException(long id) {
        super("Entity with id " + id + "not found in the database");
    }
}
