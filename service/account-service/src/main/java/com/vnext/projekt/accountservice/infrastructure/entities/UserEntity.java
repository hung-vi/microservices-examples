package com.vnext.projekt.accountservice.infrastructure.entities;

import com.vnext.projekt.accountservice.models.FullName;
import com.vnext.projekt.accountservice.models.Password;
import com.vnext.projekt.accountservice.models.User;
import com.vnext.projekt.common.models.CustomTimestamp;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@Table(name = "user", schema = "public")
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    public Long id;

    @NotNull
    public String email;

    @NotNull
    public String password;

    @NotNull
    @Column(name = "first_name")
    public String firstName;

    @NotNull
    @Column(name = "last_name")
    public String lastName;

    @NotNull
    @Column(name = "created_at")
    public OffsetDateTime createdAt;

    @NotNull
    @Column(name = "updated_at")
    public OffsetDateTime updatedAt;

    public UserEntity(@NonNull User _user) {
        if (_user.getId() != null) {
            this.id = _user.getId().toLong();
        }
        this.email = _user.getEmail().toString();
        this.password = _user.getPassword().toString();
        this.firstName = _user.getFullName().getFirstName();
        this.lastName = _user.getFullName().getLastName();
        this.createdAt = _user.getCreatedAt().toOffsetDateTime();
        this.updatedAt = _user.getUpdatedAt().toOffsetDateTime();
    }

    public User toDomainModel() {
        return new User(UserId.of(id),
                Email.of(email),
                Password.of(password),
                FullName.of(firstName, lastName),
                CustomTimestamp.of(createdAt),
                CustomTimestamp.of(updatedAt)
        );
    }
}
