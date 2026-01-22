package com.roster.domain.group.infrastructure.persistence.repository;

import com.roster.domain.group.domain.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupJpaRepository extends JpaRepository<GroupEntity, Long> {

    Optional<GroupEntity> findByGroupName(String groupName);

    boolean existsByGroupName(String groupName);
}
