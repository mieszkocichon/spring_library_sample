package com.mieszkocichon.main.services;

import com.mieszkocichon.main.beans.UserBean;
import com.mieszkocichon.main.configuration.UserDetailsConfig;
import com.mieszkocichon.main.enums.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    private final Map<String, UserDetails> stringUserBeanHashMap;

    public UserService() {
        HashMap<String, UserDetails> stringUserDetailsHashMap = new HashMap<>();
        stringUserDetailsHashMap.put("user", UserDetailsConfig.build(UserBean.USER("0", "user", "{noop}user")));
        stringUserDetailsHashMap.put("admin", UserDetailsConfig.build(UserBean.CREATE("1", "admin", "{noop}admin", UserRole.ADMIN)));

        this.stringUserBeanHashMap = stringUserDetailsHashMap;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = stringUserBeanHashMap.getOrDefault(s, null);

        if (Objects.isNull(userDetails)) {
            throw new IndexOutOfBoundsException("User does not exist.");
        }

        return userDetails;
    }
}
