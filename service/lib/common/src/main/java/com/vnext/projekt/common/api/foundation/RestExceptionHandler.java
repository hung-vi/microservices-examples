package com.vnext.projekt.common.api.foundation;

import com.vnext.projekt.common.api.responses.ApiError;
import com.vnext.projekt.common.api.responses.ErrorResponse;
import com.vnext.projekt.common.api.responses.ResourceNotFoundResponse;
import com.vnext.projekt.common.api.responses.ResourceViolationResponse;
import com.vnext.projekt.common.api.responses.ValidationFailedResponse;
import com.vnext.projekt.common.api.responses.location.Location;
import com.vnext.projekt.common.api.responses.location.LocationType;
import com.vnext.projekt.common.api.responses.location.LocationUtils;
import com.vnext.projekt.common.api.responses.validation.ErrorCode;
import com.vnext.projekt.common.exceptions.ResourceNotFoundException;
import com.vnext.projekt.common.exceptions.ResourceViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    /**
     * Some other exceptions need to be handled.
     * See {@link ResponseEntityExceptionHandler @ResponseEntityExceptionHandler} for details
     */

    @ExceptionHandler
    public ResponseEntity badRequest(ResourceViolationException _e) {
        if (_e.getErrors().isPresent()) {
            return new ResourceViolationResponse(_e.getErrors().get());
        }
        return new ErrorResponse(HttpStatus.BAD_REQUEST, "invalid request parameters");
    }


    @ExceptionHandler
    public ResponseEntity notFound(ResourceNotFoundException _e) {
        if (_e.getErrors().isPresent()) {
            return new ResourceNotFoundResponse(_e.getErrors().get());
        }
        return new ErrorResponse(HttpStatus.NOT_FOUND, "not found");
    }


    @ExceptionHandler
    public ValidationFailedResponse validationFailedResponse(MethodArgumentNotValidException _e)
    {
        List<ApiError> errors =
            _e.getBindingResult().getFieldErrors()
                .stream().map(_error -> {
                ErrorCode errorCode = ErrorCode.INVALID_PARAMETER;
                String message = _error.getDefaultMessage();
                Location location = new Location(LocationType.BODY, LocationUtils.jsonPathFromObjectErrorField(_error.getField()));

                return new ApiError(
                    errorCode,
                    message,
                    location);
            })
            .sorted(Comparator.nullsFirst(
                Comparator.comparing(_error -> _error.getLocation().map(Location::getParam).orElse(null))))
            .collect(Collectors.toList());

        return new ValidationFailedResponse(errors);
    }


    @ExceptionHandler
    public ErrorResponse handleInternalServerError(Exception _e) {
        log.error(String.format("Unhandled exception :: %s :: %s", _e.getClass(), _e.getMessage()), _e);
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error");
    }

}
