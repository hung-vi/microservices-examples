package com.vnext.projekt.photoservice.api.forms.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class PhotoProcessCreateForm
{
    @JsonProperty(required = true)
    @Length(min = 1)
    private String photoId;

    PhotoProcessCreateForm()
    {
        this.photoId = null;
    }

}
