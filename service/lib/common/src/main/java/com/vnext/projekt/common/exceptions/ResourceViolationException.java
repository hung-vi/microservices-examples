package com.vnext.projekt.common.exceptions;

import com.vnext.projekt.common.api.responses.ApiError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResourceViolationException extends ResourceException {

    private List<ApiError> errors;

    public ResourceViolationException(String _message) {
        super(_message);
    }

    public ResourceViolationException(Throwable _cause) {
        super(_cause);
    }

    public ResourceViolationException(String _message, Throwable _cause) {
        super(_message, _cause);
    }

    public ResourceViolationException(Throwable _cause, ApiError _error) {
        super(_cause);
        errors = new ArrayList<>();
        this.errors.add(_error);
    }

    public ResourceViolationException(String _message, ApiError _error) {
        super(_message);
        errors = new ArrayList<>();
        this.errors.add(_error);
    }

    public ResourceViolationException(String _message, Throwable _cause, ApiError _error) {
        super(_message, _cause);
        errors = new ArrayList<>();
        this.errors.add(_error);
    }

    public ResourceViolationException(String _message, List<ApiError> _errors) {
        super(_message);
        errors = new ArrayList<>();
        this.errors = _errors;
    }

    public ResourceViolationException(Throwable _cause, List<ApiError> _errors) {
        super(_cause);
        errors = new ArrayList<>();
        this.errors = _errors;
    }

    public ResourceViolationException(String _message, Throwable _cause, List<ApiError> _errors) {
        super(_message, _cause);
        errors = new ArrayList<>();
        this.errors = _errors;
    }

    public Optional<List<ApiError>> getErrors() {
        return Optional.ofNullable(this.errors);
    }


}
