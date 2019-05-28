package com.vnext.projekt.accountservice.services;

import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.common.exceptions.ResourceNotFoundException;
import com.vnext.projekt.common.exceptions.ResourceViolationException;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.NonNull;

public interface UserService {

    User createUser(@NonNull Email _email, @NonNull Password _password, @NonNull FullName _fullName) throws ResourceViolationException;

    User getUser(@NonNull UserId _id) throws ResourceNotFoundException;

    User updateUser(@NonNull UserId _userId);
}
