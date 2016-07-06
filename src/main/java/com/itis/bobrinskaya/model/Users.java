package com.itis.bobrinskaya.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.itis.bobrinskaya.model.enums.RoleEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ekaterina on 20.04.2016.
 */
@Entity
@SequenceGenerator(sequenceName = "users_id_seq", name = "user_gen", allocationSize = 1)
public class Users implements Serializable, UserDetails{


    private int id;
    private String login;
    private String phone;
    private String password;
    private RoleEnum role;
    private Integer bonus;
    @JsonBackReference
    private Collection<Orders> orders = new ArrayList<>();



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        String role = null;
        switch (this.getRole()){
            case ROLE_CONTENT_ADMIN: role = "ROLE_CONTENT_ADMIN";
                break;
            case ROLE_COOK_ADMIN: role = "ROLE_COOK_ADMIN";
                break;
            case ROLE_SYSTEM_ADMIN: role = "ROLE_SYSTEM_ADMIN";
                break;
            case ROLE_USER: role = "ROLE_USER";
                break;
        }
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        return grantedAuthorities;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 150)
    public String getPassword() {
        return password;
    }

    @Override
    @Transient
    public String getUsername() {
        return login;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, insertable = true, updatable = true, length = 50)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Basic
    @Column(name = "bonus", nullable = true, insertable = true, updatable = true)
    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (phone != null ? !phone.equals(users.phone) : users.phone != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (role != null ? !role.equals(users.role) : users.role != null) return false;
        if (bonus != null ? !bonus.equals(users.bonus) : users.bonus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        return result;
    }


}
