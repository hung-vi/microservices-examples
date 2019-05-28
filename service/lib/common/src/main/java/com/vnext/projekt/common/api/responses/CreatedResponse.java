package com.vnext.projekt.common.api.responses;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

public class CreatedResponse<T> extends ResponseEntity<T> {

    public CreatedResponse(T body) throws URISyntaxException {
        /*
          Temporarily set Location header as https://vnext.com.vn
         */
        super(body, headers(new URI("https://vnext.com.vn/")), HttpStatus.CREATED);
    }

    private static HttpHeaders headers(URI _location) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(_location);
        return headers;
    }
}
