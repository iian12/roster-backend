package com.roster.domain.user.domain.model;

import com.roster.domain.user.domain.model.enums.AccountStatus;
import com.roster.domain.user.domain.model.enums.Provider;
import com.roster.domain.user.domain.model.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Users {
    private final UserId userId;
    private String email;
    private String nickname;
    private String passwordHash;
    private String profileImgUrl;
    private String phone;
    private String bio;
    private AccountStatus accountStatus;
    private Role role;
    private String handle;
    private final Provider provider;
    private final String subjectId;

    @Builder
    public Users(
            String email,
            String nickname,
            String passwordHash,
            String profileImgUrl,
            String phone,
            String bio,
            AccountStatus accountStatus,
            Role role,
            String handle,
            Provider provider,
            String subjectId
    ) {
        this.userId = UserId.newId();
        this.email = email;
        this.nickname = nickname;
        this.passwordHash = passwordHash;
        this.profileImgUrl = profileImgUrl;
        this.phone = phone;
        this.bio = bio;
        this.accountStatus = accountStatus != null ? accountStatus : AccountStatus.ACTIVE;
        this.role = role != null ? role : Role.USER;
        this.handle = handle;
        this.provider = provider;
        this.subjectId = subjectId;
    }

    public static Users load(
            UserId userId,
            String email,
            String nickname,
            String passwordHash,
            String profileImgUrl,
            String phone,
            String bio,
            AccountStatus accountStatus,
            Role role,
            String handle,
            Provider provider,
            String subjectId
    ) {
        return new Users(
                userId, email, nickname, passwordHash, profileImgUrl,
                phone, bio, accountStatus, role, handle, provider, subjectId
        );
    }

    // 조회 전용 생성자 (외부에서 직접 호출 불가능)
    Users(UserId userId, String email, String nickname, String passwordHash, String profileImgUrl,
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

    public void changeEmail(String newEmail) {
        this.email = newEmail;
    }

    public void changePhone(String newPhone) {
        this.phone = newPhone;
    }

    public void changeRole(Role newRole) {
        this.role = newRole;
    }

    public void changeHandle(String newHandle) {
        this.handle = newHandle;
    }

    public void changeNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void changePasswordHash(String newPasswordHash) {
        this.passwordHash = newPasswordHash;
    }

    public void changeProfileImageUrl(String newProfileImgUrl) {
        this.profileImgUrl = newProfileImgUrl;
    }

    public void changeBio(String newBio) {
        this.bio = newBio;
    }

    public void changeAccountStatus(AccountStatus newAccountStatus) {
        this.accountStatus = newAccountStatus;
    }
}
