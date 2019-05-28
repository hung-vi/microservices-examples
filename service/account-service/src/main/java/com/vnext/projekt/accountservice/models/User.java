package com.vnext.projekt.accountservice.models;

import com.vnext.projekt.common.models.CustomTimestamp;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@AllArgsConstructor
@Value
@Builder(builderClassName = "Builder", toBuilder = true)
public class User {

    private UserId id;

    private Email email;

    private Password password;

    private FullName fullName;

    private CustomTimestamp createdAt;

    private CustomTimestamp updatedAt;

}
