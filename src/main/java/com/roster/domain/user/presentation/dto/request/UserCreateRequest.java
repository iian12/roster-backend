package com.roster.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String nickname;

    private String phone;
    private String handle;

    public UserCreateRequest(String email, String password, String nickname, String phone, String handle) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.handle = handle;
    }
}
