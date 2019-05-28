package com.vnext.projekt.accountservice.repositories.internal;

import com.vnext.projekt.accountservice.infrastructure.dao.UserDao;
import com.vnext.projekt.accountservice.infrastructure.entities.UserEntity;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.accountservice.models.UserSpecifications;
import com.vnext.projekt.accountservice.repositories.UserRepository;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class DefaultUserRepository implements UserRepository {

    private UserDao userDao;

    @Override
    public Optional<User> find(UserId _id) {
        return userDao.findById(_id.toLong()).map(UserEntity::toDomainModel);
    }

    @Override
    public Optional<User> findByEmail(Email _email) {
        Specification<UserEntity> spec = UserSpecifications.emailEqual(_email);
        return userDao.findOne(spec).map(UserEntity::toDomainModel);
    }

    @Override
    public User save(User _user) {
        UserEntity entity = new UserEntity(_user);
        this.userDao.saveAndFlush(entity);
        return _user.toBuilder()
                .id(UserId.of(entity.id))
                .build();
    }

    @Override
    public void delete(UserId _id) {
        userDao.deleteById(_id.toLong());
    }
}
