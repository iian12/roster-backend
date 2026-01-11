package com.roster.domain.user.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResult {

    private final String email;
    private final String nickname;
    private final String profileImgUrl;
    private final String bio;

    public UserResult(
            String email,
            String nickname,
            String profileImgUrl,
            String bio
    ) {
        this.email = email;
        this.nickname = nickname;
        this.profileImgUrl = profileImgUrl;
        this.bio = bio;
    }
}
