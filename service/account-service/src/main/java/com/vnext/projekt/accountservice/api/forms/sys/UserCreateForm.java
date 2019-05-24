package com.vnext.projekt.accountservice.api.forms.sys;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vnext.projekt.common.utils.validation.Email;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Value
public class UserCreateForm {

    @JsonProperty(required = true)
    @NotNull
    @Length(max = 128, message = "email must be less than 128 characters")
    @Email
    private String email;

    @JsonProperty(required = true)
    @NotNull
    @Length(min = 8, max = 128)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)[!-~]*$")
    private String password;

    @JsonProperty(required = true)
    @NotNull
    @Length(min = 1, max = 32)
    private String firstName;

    @JsonProperty(required = true)
    @NotNull
    @Length(min = 1, max = 32)
    private String lastName;
}
