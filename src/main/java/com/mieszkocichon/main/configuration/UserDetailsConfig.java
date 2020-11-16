package com.mieszkocichon.main.configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mieszkocichon.main.beans.UserBean;
import com.mieszkocichon.main.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Service
public class UserDetailsConfig implements UserDetails {

    private String id;
    private String username;
    private UserRole userRole;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsConfig build(UserBean userBean) {
        UserDetailsConfig userDetailsConfig = new UserDetailsConfig();
        userDetailsConfig.setId(userBean.getId());
        userDetailsConfig.setUsername(userBean.getName());
        userDetailsConfig.setPassword(userBean.getPassword());

        UserRole userRole = userBean.getRole();
        userDetailsConfig.setUserRole(userRole);
        userDetailsConfig.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority(String.format("ROLE_%s", userRole.name()))));

        return userDetailsConfig;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsConfig that = (UserDetailsConfig) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities);
    }
}
