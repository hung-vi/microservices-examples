package com.vnext.projekt.accountservice.models;

import com.vnext.projekt.accountservice.infrastructure.entities.UserEntity;
import com.vnext.projekt.common.models.Email;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@UtilityClass
public class UserSpecifications {

    public static Specification<UserEntity> emailEqual(@NonNull Email _email) {
        return (Root<UserEntity> _root, CriteriaQuery<?> _query, CriteriaBuilder _cb) -> _cb.equal(_root.get("email"), _email.toString());
    }
}
