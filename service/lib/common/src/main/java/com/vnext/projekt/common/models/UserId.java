package com.vnext.projekt.common.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Embeddable
public class UserId implements Serializable {
    @NonNull
    private Long id;

    public static UserId of(@NonNull String _id) {
        return UserId.of(Long.parseLong(_id));
    }

    @Override
    public String toString() {
        return this.id.toString();
    }

    public Long toLong() {
        return this.id;
    }

}
