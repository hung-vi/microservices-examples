package com.vnext.projekt.common.api.responses;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceNotFoundResponse extends ResponseEntity<ResourceNotFoundResponse.Payload> {

    public ResourceNotFoundResponse(@NonNull List<ApiError> _error) {
        super(new Payload(HttpStatus.NOT_FOUND.value(), "validation failed", errorViews(_error)), HttpStatus.NOT_FOUND);
    }

    private static List<ApiErrorView> errorViews(List<ApiError> _errors) {
        return _errors.stream().map(ApiErrorView::new).collect(Collectors.toList());
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Payload {

        @NonNull
        @Getter
        private Integer status;

        @NonNull
        @Getter
        private String message;

        @NonNull
        @Getter
        private List<ApiErrorView> errors;
    }
}
