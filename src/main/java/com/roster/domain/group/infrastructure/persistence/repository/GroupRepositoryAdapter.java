package com.roster.domain.group.infrastructure.persistence.repository;

import com.roster.domain.group.domain.model.GroupEntity;
import com.roster.domain.group.domain.model.GroupId;
import com.roster.domain.group.domain.model.Groups;
import com.roster.domain.group.domain.port.out.GroupRepository;
import com.roster.domain.group.infrastructure.persistence.rmapper.GroupMapper;
import com.roster.domain.user.domain.port.out.UserRepository;

import java.util.Optional;

public class GroupRepositoryAdapter implements GroupRepository {

    private final GroupJpaRepository groupJpaRepository;

    public GroupRepositoryAdapter(GroupJpaRepository groupJpaRepository) {
        this.groupJpaRepository = groupJpaRepository;
    }


    @Override
    public Groups save(Groups groups) {
        GroupEntity entity = GroupMapper.toEntity(groups);
        GroupEntity saved = groupJpaRepository.save(entity);
        return GroupMapper.toDomain(saved);
    }

    @Override
    public Optional<Groups> findById(GroupId groupId) {
        return groupJpaRepository.findById(groupId.value())
                .map(GroupMapper::toDomain);
    }

    @Override
    public Optional<Groups> findByName(String groupName) {
        return groupJpaRepository.findByGroupName(groupName)
                .map(GroupMapper::toDomain);
    }

    @Override
    public boolean existsById(GroupId groupId) {
        return groupJpaRepository.existsById(groupId.value());
    }

    @Override
    public boolean existsByName(String groupName) {
        return groupJpaRepository.existsByGroupName(groupName);
    }
}
