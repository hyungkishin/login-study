package com.loginstudy.loginstudy.login.repository;

import com.loginstudy.loginstudy.login.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);

    UserEntity findByUsername(String username);

}
