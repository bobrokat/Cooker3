package com.itis.bobrinskaya.repository;

import com.itis.bobrinskaya.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ekaterina on 22.04.2016.
 */
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByLogin(String login);

    Users findByPhone(String phone);
}
