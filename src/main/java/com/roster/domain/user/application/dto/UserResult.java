package com.roster.domain.user.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResult {

    private final String email;
}
