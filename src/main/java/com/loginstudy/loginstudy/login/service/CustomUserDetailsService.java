package com.loginstudy.loginstudy.login.service;

import com.loginstudy.loginstudy.login.domain.UserEntity;
import com.loginstudy.loginstudy.login.domain.dto.CustomUserDetails;
import com.loginstudy.loginstudy.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //DB에서 조회
        UserEntity userData = userRepository.findByUsername(username);

        if (userData != null) {

            //UserDetails 에 담아서 return 하면 AutneticationManager 가 검증 함
            return new CustomUserDetails(userData);
        }

        return null;
    }
}