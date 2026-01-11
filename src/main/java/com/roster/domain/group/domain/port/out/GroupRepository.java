package com.roster.domain.group.domain.port.out;

import com.roster.domain.group.domain.model.GroupId;
import com.roster.domain.group.domain.model.Groups;

import java.util.Optional;

public interface GroupRepository {

    Groups save(Groups groups);

    Optional<Groups> findById(GroupId groupId);

    Optional<Groups> findByName(String groupName);

    boolean existsById(GroupId groupId);

    boolean existsByName(String groupName);
}
