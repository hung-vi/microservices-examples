package com.vnext.projekt.accountservice.services.internal;

import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.accountservice.repositories.UserRepository;
import com.vnext.projekt.accountservice.services.UserService;
import com.vnext.projekt.common.api.responses.ApiError;
import com.vnext.projekt.common.api.responses.location.Location;
import com.vnext.projekt.common.api.responses.location.LocationType;
import com.vnext.projekt.common.api.responses.validation.ErrorCode;
import com.vnext.projekt.common.exceptions.ResourceException;
import com.vnext.projekt.common.exceptions.ResourceNotFoundException;
import com.vnext.projekt.common.exceptions.ResourceViolationException;
import com.vnext.projekt.common.models.CustomTimestamp;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DefaultUserService implements UserService {

    UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User createUser(@NonNull Email _email, @NonNull Password _password, @NonNull FullName _fullName) throws ResourceViolationException {
        CustomTimestamp now = CustomTimestamp.now();
        User user = new User(null, _email, _password, _fullName, now, now);
        try {
            return this.userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceViolationException("already exist", new ApiError(ErrorCode.ALREADY_EXISTS, "email duplicated", new Location(LocationType.BODY, "/email")));
        }
    }

    @Transactional(readOnly = true, rollbackFor = ResourceException.class)
    @Override
    public User getUser(@NonNull UserId _id) throws ResourceNotFoundException {
        return this.userRepository.find(_id)
            .orElseThrow(() -> new ResourceNotFoundException(String.format("\"%s\" user not found", _id)));
    }

    @Override
    public User updateUser(@NonNull UserId _userId) {
        return null;
    }

}
