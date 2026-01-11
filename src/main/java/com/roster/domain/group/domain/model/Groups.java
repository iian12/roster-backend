package com.roster.domain.group.domain.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Groups {

    private final GroupId groupid;
    private String groupName;
    private String description;

    @Builder
    public Groups(String groupName, String description) {
        this.groupid = GroupId.newId();
        this.groupName = groupName;
        this.description = description;
    }

    public static Groups load(GroupId groupId, String groupName, String description) {
        return new Groups(
                groupId,
                groupName,
                description
        );
    }

    Groups(GroupId groupid, String groupName, String description) {
        this.groupid = groupid;
        this.groupName = groupName;
        this.description = description;
    }

    public void changeGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void changeDescription(String description) {
        this.description = description;
    }
}
