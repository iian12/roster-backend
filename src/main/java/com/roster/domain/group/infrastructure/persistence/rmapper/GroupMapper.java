package com.roster.domain.group.infrastructure.persistence.rmapper;

import com.roster.domain.group.domain.model.GroupEntity;
import com.roster.domain.group.domain.model.GroupId;
import com.roster.domain.group.domain.model.Groups;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupMapper {

    public static Groups toDomain(GroupEntity e) {
        if (e == null) return null;

        return Groups.load(
                e.getGroupId() != null ? GroupId.of(e.getGroupId()) : null,
                e.getGroupName(),
                e.getDescription()
        );
    }

    public static GroupEntity toEntity(Groups d) {
        if (d == null) return null;

        return new GroupEntity(
                d.getGroupid().value(),
                d.getGroupName(),
                d.getDescription()
        );
    }
}
