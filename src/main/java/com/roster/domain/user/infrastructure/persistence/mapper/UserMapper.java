package com.roster.domain.user.infrastructure.persistence.mapper;

import com.roster.domain.user.domain.model.UserEntity;
import com.roster.domain.user.domain.model.UserId;
import com.roster.domain.user.domain.model.Users;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserMapper {

    public static Users toDomain(UserEntity e) {
        if (e == null) return null;

        return Users.load(
                new UserId(e.getUserId()),
                e.getEmail(),
                e.getNickname(),
                e.getPasswordHash(),
                e.getProfileImgUrl(),
                e.getPhone(),
                e.getBio(),
                e.getAccountStatus(),
                e.getRole(),
                e.getHandle(),
                e.getProvider(),
                e.getSubjectId()
        );
    }

    public static UserEntity toEntity(Users d) {
        if (d == null) return null;

        return new UserEntity(
                d.getUserId().value(),
                d.getEmail(),
                d.getNickname(),
                d.getPasswordHash(),
                d.getProfileImgUrl(),
                d.getPhone(),
                d.getBio(),
                d.getAccountStatus(),
                d.getRole(),
                d.getHandle(),
                d.getProvider(),
                d.getSubjectId()
        );
    }
}
