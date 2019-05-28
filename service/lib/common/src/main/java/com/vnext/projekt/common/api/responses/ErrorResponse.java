package com.vnext.projekt.common.api.responses;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse extends ResponseEntity<ErrorResponse.Payload> {

    public ErrorResponse(@NonNull HttpStatus _httpStatus, @NonNull String _message) {
        super(new Payload(_httpStatus.value(), _message), _httpStatus);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Payload {

        @NonNull
        @Getter
        private Integer status;

        @NonNull
        @Setter
        private String message;
    }
}
