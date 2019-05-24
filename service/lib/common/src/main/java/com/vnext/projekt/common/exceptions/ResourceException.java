package com.vnext.projekt.common.exceptions;

public class ResourceException extends Exception {

    public ResourceException() {
        super();
    }

    public ResourceException(String _message) {
        super(_message);
    }

    public ResourceException(Throwable _cause) {
        super(_cause);
    }

    public ResourceException(String _message, Throwable _cause) {
        super(_message, _cause);
    }
}
