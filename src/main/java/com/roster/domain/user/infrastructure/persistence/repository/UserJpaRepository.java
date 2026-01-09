package com.roster.domain.user.infrastructure.persistence.repository;

import com.roster.domain.user.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByHandle(String handle);

    boolean existsByEmail(String email);

    boolean existsByHandle(String handle);
}
