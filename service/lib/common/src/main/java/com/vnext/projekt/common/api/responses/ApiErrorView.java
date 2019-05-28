package com.vnext.projekt.common.api.responses;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode
class ApiErrorView {

    @NonNull
    private String errorCode;

    @NonNull
    private String message;

    private String locationType;

    private String param;

    ApiErrorView(@NonNull ApiError _apiError) {
        this.errorCode = _apiError.getErrorCode().getValue();
        this.message = _apiError.getMessage();
        if (_apiError.getLocation().isPresent()) {
            this.locationType = _apiError.getLocation().get().getLocationType().toString();
            this.param = _apiError.getLocation().get().getParam();
        } else {
            this.locationType = null;
            this.param = null;
        }
    }
}
