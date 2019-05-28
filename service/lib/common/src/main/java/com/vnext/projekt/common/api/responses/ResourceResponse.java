package com.vnext.projekt.common.api.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResourceResponse<T> extends ResponseEntity<T> {

    public ResourceResponse(T _body) {
        super(_body, HttpStatus.OK);
    }
}
