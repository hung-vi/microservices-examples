package com.vnext.projekt.accountservice.api.views.sys;

import com.vnext.projekt.accountservice.models.User;
import lombok.NonNull;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
public class UserView {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UserView(@NonNull User _user) {
        this.id = _user.getId().toString();
        this.email = _user.getEmail().toString();
        this.firstName = _user.getFullName().getFirstName();
        this.lastName = _user.getFullName().getLastName();
        this.createdAt = _user.getCreatedAt().toOffsetDateTime();
        this.updatedAt = _user.getUpdatedAt().toOffsetDateTime();
    }
}
