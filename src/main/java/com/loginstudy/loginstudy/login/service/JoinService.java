package com.loginstudy.loginstudy.login.service;

import com.loginstudy.loginstudy.login.domain.UserEntity;
import com.loginstudy.loginstudy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(UserEntity entity) {

        String username = entity.getUsername();
        String password = entity.getPassword();

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            // TODO Make Common checked Exception + ENUM
            throw new IllegalArgumentException("이미 존재하는 User.");
        }

        entity.updateEncodePassword(bCryptPasswordEncoder.encode(password));

        userRepository.save(entity);
    }

}
