package com.vnext.projekt.accountservice.services.internal;

import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.accountservice.repositories.UserRepository;
import com.vnext.projekt.accountservice.services.UserService;
import com.vnext.projekt.common.exceptions.ResourceNotFoundException;
import com.vnext.projekt.common.models.CustomTimestamp;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User createUser(@NonNull Email _email, @NonNull Password _password, @NonNull FullName _fullName) {
        CustomTimestamp now = CustomTimestamp.now();
        User user = new User(null, _email, _password, _fullName, now, now);
        this.userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public User getUser(@NonNull UserId _id) throws ResourceNotFoundException {
         return this.userRepository.findById(_id).orElseThrow(() ->
                 new ResourceNotFoundException(String.format("\"%s\" user not found", _id)));
    }
}
