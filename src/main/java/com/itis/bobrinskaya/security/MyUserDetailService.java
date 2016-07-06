package com.itis.bobrinskaya.security;

import com.itis.bobrinskaya.model.Users;
import com.itis.bobrinskaya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Ekaterina on 06.05.2016.
 */

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userService.getOneByLogin(s);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + s + " no found");
        }
        return user;
    }
}
