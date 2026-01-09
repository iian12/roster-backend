package com.roster.domain.user.infrastructure.persistence.repository;

import com.roster.domain.user.domain.model.UserEntity;
import com.roster.domain.user.domain.model.UserId;
import com.roster.domain.user.domain.model.Users;
import com.roster.domain.user.domain.port.out.UserRepository;
import com.roster.domain.user.infrastructure.persistence.mapper.UserMapper;

import java.util.Optional;

public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Users save(Users user) {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity saved = userJpaRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public Optional<Users> findById(UserId userId) {
        return userJpaRepository.findById(userId.value())
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }

    @Override
    public Optional<Users> findByHandle(String handle) {
        return userJpaRepository.findByHandle(handle)
                .map(UserMapper::toDomain);
    }

    @Override
    public boolean existsById(UserId userId) {
        return userJpaRepository.existsById(userId.value());
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByHandle(String handle) {
        return userJpaRepository.existsByHandle(handle);
    }
}
