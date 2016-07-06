package com.itis.bobrinskaya.api.service.impl;

import com.itis.bobrinskaya.api.service.AuthService;
import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.model.enums.RoleEnum;
import com.itis.bobrinskaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Ekaterina on 27.05.2016.
 */

@Service
public class AuthServiceImpl implements AuthService {

@Autowired
    UserRepository userRepository;

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public boolean authAdmin(String password, String login) {
       Users user = userRepository.findByLogin(login);
        return user != null && !(!encoder.matches(password, user.getPassword()) && !password.equals(user.getPassword()))
                && (user.getRole().equals(RoleEnum.ROLE_CONTENT_ADMIN) || (user.getRole().equals(RoleEnum.ROLE_SYSTEM_ADMIN)));
    }
}
