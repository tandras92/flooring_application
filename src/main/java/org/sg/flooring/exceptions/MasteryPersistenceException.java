package org.sg.flooring.exceptions;

public class MasteryPersistenceException extends Exception {

    public MasteryPersistenceException() {
    }

    public MasteryPersistenceException(String message) {
        super(message);
    }

    public MasteryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public MasteryPersistenceException(Throwable cause) {
        super(cause);
    }

    public MasteryPersistenceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
