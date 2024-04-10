package com.loginstudy.loginstudy.login.repository;

import com.loginstudy.loginstudy.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
