package com.vnext.projekt.common.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.AttributeConverter;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Embeddable
public class UserId implements Serializable {
    @NonNull
    @javax.validation.constraints.Email
    private Long value;

    public static UserId of(@NonNull String _id) {
        return UserId.of(Long.parseLong(_id));
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public Long toLong() {
        return this.value;
    }

    public static class JpaConverter implements AttributeConverter<UserId, Long> {
        @Override
        public Long convertToDatabaseColumn(UserId _attribute) {
            return _attribute.value;
        }

        @Override
        public UserId convertToEntityAttribute(Long _dbData) {
            return UserId.of(_dbData);
        }
    }
}
