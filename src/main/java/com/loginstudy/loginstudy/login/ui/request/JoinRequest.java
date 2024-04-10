package com.loginstudy.loginstudy.login.ui.request;

import com.loginstudy.loginstudy.login.domain.UserEntity;
import lombok.Getter;

@Getter
public class JoinRequest {

    private String username;

    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .username(username)
                .password(password)
                .role("ROLE_USER")
                .build();
    }

}
