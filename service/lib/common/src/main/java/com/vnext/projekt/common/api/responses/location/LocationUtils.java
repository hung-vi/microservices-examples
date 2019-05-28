package com.vnext.projekt.common.api.responses.location;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@UtilityClass
public class LocationUtils {

    public static String jsonPathFromObjectErrorField(String _field)
    {
        String jsonPath = "/" + StringUtils.replace(_field, "\\", "/");

        jsonPath = jsonPath.replaceAll("//", "/");
        if (jsonPath.endsWith("/")) {
            jsonPath = StringUtils.substring(jsonPath, 0, -1);
        }

        return jsonPath;
    }

    public static String jsonPathFromJacksonPath(List<JsonMappingException.Reference> _path) {
        return "/" + _path.stream().map(_ref -> {
           if (0 <= _ref.getIndex()) {
               return Integer.toString(_ref.getIndex());
           }
           return _ref.getFieldName();
        });
    }
}
