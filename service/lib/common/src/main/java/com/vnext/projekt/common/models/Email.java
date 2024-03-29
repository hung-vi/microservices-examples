package com.vnext.projekt.common.models;


import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

@EqualsAndHashCode
public class Email {

    @NonNull
    @javax.validation.constraints.Email
    private final String email;

    private Email(String _email) {
        this.email = _email;
    }

    public static Email of(@NonNull String _email) {
        return new Email(_email.toLowerCase());
    }

    @Override
    public String toString() {
        return this.email;
    }

    public String getLocalPart() {
        return StringUtils.split(this.email, "@", 2)[0];
    }

    public String getDomainPart() {
        return StringUtils.split(this.email, "@", 2)[1];
    }

}
