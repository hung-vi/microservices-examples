package com.vnext.projekt.common.api.responses.validation;

import com.vnext.projekt.common.utils.StringCaseUtils;
import lombok.NonNull;

public enum ErrorCode {

    INVALID_PARAMETER,

    MISSING_PARAMETER,

    ALREADY_EXISTS,

    MISSING_PREFERENCE;

    public String getValue() {
        return StringCaseUtils.snakeCaseToCamelCase(this.name().toLowerCase());
    }

    public static ErrorCode of(@NonNull String _value) {
        return ErrorCode.valueOf(StringCaseUtils.camelCaseToSnakeCase(_value.toUpperCase()));
    }
}
