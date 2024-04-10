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
            // TODO make checked Exception
            return;
        }

        entity.updateEncodePassword(bCryptPasswordEncoder.encode(password));

        System.out.println("isExist = " + entity.getPassword());
        userRepository.save(entity);
    }

}
