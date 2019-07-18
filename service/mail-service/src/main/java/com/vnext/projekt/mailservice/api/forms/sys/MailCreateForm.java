package com.vnext.projekt.mailservice.api.forms.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class MailCreateForm
{
    @JsonProperty(required = true)
    @Length(min = 1, max = 100)
    @NonNull
    private String to;

    @JsonProperty(required = true)
    @Length(min = 1, max = 500)
    @NonNull
    private String body;

    public MailCreateForm()
    {
        this.to = null;
        this.body = null;
    }
}
