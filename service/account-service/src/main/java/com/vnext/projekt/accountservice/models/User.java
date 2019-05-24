package com.vnext.projekt.accountservice.models;

import com.vnext.projekt.common.models.CustomTimestamp;
import com.vnext.projekt.common.models.Email;
import com.vnext.projekt.common.models.UserId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@Entity
@IdClass(UserId.class)
@Table(name = "user", schema = "public")
public class User {

    @Id
    @Column(name = "id")
    private Long tableId;

    @Transient
    @Getter
    private UserId id;

    @Column(name = "email")
    @NotNull
    @Getter
    @Convert(converter = Email.JpaConverter.class)
    private Email email;

    @NotNull
    @Getter
    @Convert(converter = Password.JpaConverter.class)
    private Password password;

    @Embedded
    @NotNull
    @Getter
    private FullName fullName;

    @Column(name = "created_at")
    @NotNull
    @Getter
    @Convert(converter = CustomTimestamp.JpaConverter.class)
    private CustomTimestamp createdAt;

    @Column(name = "updated_at")
    @NotNull
    @Getter
    @Convert(converter = CustomTimestamp.JpaConverter.class)
    private CustomTimestamp updatedAt;

    public User(
            UserId _id,
            @NonNull Email _email,
            @NonNull Password _password,
            @NonNull FullName _fullName,
            @NonNull CustomTimestamp _createdAt,
            @NonNull CustomTimestamp _updatedAt)
    {
        if (_id != null) {
            this.tableId = _id.toLong();
            this.id = _id;
        }

        this.email = _email;
        this.password = _password;
        this.fullName = _fullName;
        this.createdAt = _createdAt;
        this.updatedAt = _updatedAt;
    }

    public void setId(@NonNull UserId _id) {
        this.tableId = _id.toLong();
        this.id = _id;
    }

    @PostPersist
    @PostLoad
    private void setupId() {
        this.id = UserId.of(this.tableId);
    }

}
