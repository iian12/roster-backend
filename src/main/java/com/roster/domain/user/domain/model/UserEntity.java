package com.roster.domain.user.domain.model;

import com.roster.domain.user.domain.model.enums.AccountStatus;
import com.roster.domain.user.domain.model.enums.Provider;
import com.roster.domain.user.domain.model.enums.Role;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    private Long userId;

    @Column(unique = true, length = 20)
    private String email;

    @Column(length = 50)
    private String nickname;

    private String passwordHash;

    private String profileImgUrl;

    private String phone;

    private String bio;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true)
    private String handle;

    @Enumerated(EnumType.STRING)
    private Provider provider;

    private String subjectId;

    public UserEntity(Long userId, String email, String nickname, String passwordHash, String profileImgUrl,
                      String phone, String bio, AccountStatus accountStatus, Role role, String handle,
                      Provider provider, String subjectId) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.passwordHash = passwordHash;
        this.profileImgUrl = profileImgUrl;
        this.phone = phone;
        this.bio = bio;
        this.accountStatus = accountStatus;
        this.role = role;
        this.handle = handle;
        this.provider = provider;
        this.subjectId = subjectId;
    }

    public static UserEntity fromDomain(Users domain) {
        return new UserEntity(
                domain.getUserId().value(),
                domain.getEmail(),
                domain.getNickname(),
                domain.getPasswordHash(),
                domain.getProfileImgUrl(),
                domain.getPhone(),
                domain.getBio(),
                domain.getAccountStatus(),
                domain.getRole(),
                domain.getHandle(),
                domain.getProvider(),
                domain.getSubjectId()
        );
    }
}
