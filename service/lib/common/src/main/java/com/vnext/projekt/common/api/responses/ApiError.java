package com.vnext.projekt.common.api.responses;

import com.vnext.projekt.common.api.responses.location.Location;
import com.vnext.projekt.common.api.responses.validation.ErrorCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@RequiredArgsConstructor
public class ApiError {

    @NonNull
    @Getter
    private ErrorCode errorCode;

    @NonNull
    @Getter
    private String message;

    private Location location;

    public Optional<Location> getLocation() {
        return Optional.ofNullable(this.location);
    }

    @Override
    public String toString() {
        return "ApiError{" +
            "errorCode=" + errorCode +
            ", message='" + message + '\'' +
            ", location=" + location +
            '}';
    }
}
