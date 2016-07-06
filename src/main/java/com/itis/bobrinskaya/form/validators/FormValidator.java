package com.itis.bobrinskaya.form.validators;

import com.itis.bobrinskaya.form.RegistrationForm;
import com.itis.bobrinskaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Ekaterina on 06.05.2016.
 */
@Component
@Qualifier("RegFormValidator")
public class FormValidator  {

    @Autowired
    UserRepository userRepository;

    public void validate(RegistrationForm form) {
        if (userRepository.findByLogin(form.getLogin()) != null) {
            System.out.println("login is used already");
        }
        if (!form.getPassword().equals(form.getRepassword())) {
            System.out.println("passwords doesn't match");
        }
    }
}
