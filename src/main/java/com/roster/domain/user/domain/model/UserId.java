package com.roster.domain.user.domain.model;

import com.roster.global.TsidCreator;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public record UserId(Long value) implements Serializable {

    public static UserId of(Long value) {
        return new UserId(value);
    }

    public static UserId newId() {
        return new UserId(TsidCreator.create());
    }
}
