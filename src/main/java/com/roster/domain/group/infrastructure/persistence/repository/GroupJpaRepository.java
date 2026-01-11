package com.roster.domain.group.infrastructure.persistence.repository;

import com.roster.domain.group.domain.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupEntity, Long> {
}
