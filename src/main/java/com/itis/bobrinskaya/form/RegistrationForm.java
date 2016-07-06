package com.itis.bobrinskaya.form;

import com.itis.bobrinskaya.model.enums.RoleEnum;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Ekaterina on 26.04.2016.
 */
public class RegistrationForm {
    @Size(min = 5, max = 30, message = "логин должен быть от 5 до 30 символов")
    @NotEmpty(message = "поле не должно быть пустым")
    private String login;
    @Size(min = 10, max = 30, message = "номер должен быть от 10 до 30 символов")
    @NotEmpty(message = "поле не должно быть пустым")
    private String phone;
    @Size(min = 6, max = 30, message = "пароль должен быть от 6 до 30 символов")
    @NotEmpty(message = "поле не должно быть пустым")
    private String password;
    @Size(min = 6, max = 30, message = "пароль должен быть от 6 до 30 символов")
    @NotEmpty(message = "поле не должно быть пустым")
    private String repassword;
    private RoleEnum role = RoleEnum.ROLE_USER;

    public RoleEnum getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
