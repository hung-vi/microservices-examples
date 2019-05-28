package com.vnext.projekt.accountservice.repositories;

import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;

import java.util.Optional;

public interface UserRepository {

    Optional<User> find(UserId _id);

    Optional<User> findByEmail(Email _email);

    User save(User _user);

    void delete(UserId _id);

}
