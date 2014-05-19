package com.mype.richhome.persistence;

/**
 * @author Vitaliy Gerya
 */
public class DataException extends RuntimeException {
    public DataException() {
    }

    public DataException(final String message) {
        super(message);
    }

    public DataException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DataException(final Throwable cause) {
        super(cause);
    }

    public DataException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
