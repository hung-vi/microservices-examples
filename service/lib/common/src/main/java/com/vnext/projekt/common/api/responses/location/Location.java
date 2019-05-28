package com.vnext.projekt.common.api.responses.location;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Location {

    @Getter
    private LocationType locationType;

    @Getter
    private String param;

}
