package com.tpr.engine.exception;

public class TprIllegalArgumentException extends TprException {

    private static final long serialVersionUID = 1L;

    public TprIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public TprIllegalArgumentException(String message) {
        super(message);
    }
}
