package com.vnext.projekt.accountservice.models;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Value
@ToString(includeFieldNames = false)
@NoArgsConstructor(force = true)
@Embeddable
public class FullName {

    @Column(name = "first_name")
    @NonNull
    @Length(min = 1, max = 32)
    private String firstName;

    @Column(name = "last_name")
    @NonNull
    @Length(min = 1, max = 32)
    private String lastName;

    private FullName(@NonNull String _firstName, @NonNull String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;
    }

    public static FullName of(@NonNull String _firstName, @NonNull String _lastName) {
        if (StringUtils.isBlank(_firstName)) {
            throw new IllegalArgumentException("invalid firstName");
        }

        if (StringUtils.isBlank(_lastName)) {
            throw new IllegalArgumentException("invalid lastName");
        }

        return new FullName(_firstName, _lastName);
    }
}
