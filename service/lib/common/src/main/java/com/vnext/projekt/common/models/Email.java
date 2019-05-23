package com.vnext.projekt.common.models;


import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@EqualsAndHashCode
public class Email {

    @NonNull
    @javax.validation.constraints.Email
    private final String value;

    private Email(String _value) {
        this.value = _value;
    }

    public static Email of(@NonNull String _email) {
        return new Email(_email.toLowerCase());
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getLocalPart() {
        return StringUtils.split(this.value, "@", 2)[0];
    }

    public String getDomainPart() {
        return StringUtils.split(this.value, "@", 2)[1];
    }

    @Converter(autoApply = true)
    public static class JpaConverter implements AttributeConverter<Email, String> {

        @Override
        public String convertToDatabaseColumn(Email _attribute) {
            return _attribute.toString();
        }

        @Override
        public Email convertToEntityAttribute(String dbData) {
            return Email.of(dbData);
        }
    }
}
