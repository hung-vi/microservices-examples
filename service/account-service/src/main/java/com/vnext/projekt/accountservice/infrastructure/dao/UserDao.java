package com.vnext.projekt.accountservice.infrastructure.dao;

import com.vnext.projekt.accountservice.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
}
