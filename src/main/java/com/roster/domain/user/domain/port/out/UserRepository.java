package com.roster.domain.user.domain.port.out;

import com.roster.domain.user.domain.model.UserId;
import com.roster.domain.user.domain.model.Users;

import java.util.Optional;

public interface UserRepository {

    Users save(Users user);

    Optional<Users> findById(UserId userId);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByHandle(String handle);

    boolean existsById(UserId userId);

    boolean existsByEmail(String email);

    boolean existsByHandle(String handle);
}
