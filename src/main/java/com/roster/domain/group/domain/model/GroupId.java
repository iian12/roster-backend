package com.roster.domain.group.domain.model;

import com.roster.global.TsidCreator;
import jakarta.persistence.Embeddable;

@Embeddable
public record GroupId(Long value) {
    public static GroupId of(Long value) {
        return new GroupId(value);
    }

    public static GroupId newId() {
        return new GroupId(TsidCreator.create());
    }
}
