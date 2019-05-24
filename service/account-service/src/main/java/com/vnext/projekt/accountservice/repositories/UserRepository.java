package com.vnext.projekt.accountservice.repositories;

import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.common.models.UserId;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UserId>, JpaSpecificationExecutor<User> {

}
