package com.vnext.projekt.mailservice.api.forms.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vnext.projekt.common.utils.validation.Email;
import lombok.NonNull;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Value
public class MailCreateForm
{
    @JsonProperty(required = true)
    @NotNull
    @Length(max = 128, message = "email must be less than 128 characters")
    @Email
    private String from;

    @JsonProperty(required = true)
    @NotNull
    @Length(max = 128, message = "email must be less than 128 characters")
    @Email
    private String to;

    @JsonProperty(required = true)
    @Length(min = 1, max = 100)
    @NonNull
    private String subject;

    @JsonProperty(required = true)
    @Length(min = 1, max = 500)
    @NonNull
    private String body;

    public MailCreateForm()
    {
        this.from = null;
        this.to = null;
        this.subject = null;
        this.body = null;
    }
}
