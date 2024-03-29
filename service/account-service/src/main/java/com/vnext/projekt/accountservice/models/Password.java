package com.vnext.projekt.accountservice.models;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

@EqualsAndHashCode
public class Password {

    @NonNull
    private String hash;

    private Password(@NonNull String _hash) {
        this.hash = _hash;
    }

    public static Password of(@NonNull String _rawPassword) {
        String hash = hash(_rawPassword);
        return new Password(hash);
    }

    public static Password ofHash(@NonNull String _hash) {
        return new Password(_hash);
    }

    private static String hash(String _rawPassword) {
        return BCrypt.hashpw(_rawPassword, BCrypt.gensalt());
    }

    public boolean matches(String _rawPassword) {
        if (_rawPassword == null) return false;
        return BCrypt.checkpw(_rawPassword, this.hash);
    }

    private String toHash() {
        return this.hash;
    }

}
