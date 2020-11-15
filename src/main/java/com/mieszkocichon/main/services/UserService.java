package com.mieszkocichon.main.services;

import com.mieszkocichon.main.beans.UserBean;
import com.mieszkocichon.main.configuration.UserDetailsService;
import com.mieszkocichon.main.enums.UserRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, UserDetails> stringUserBeanHashMap;

    public UserService() {
        HashMap<String, UserDetails> stringUserDetailsHashMap = new HashMap<>();
        stringUserDetailsHashMap.put("user", UserDetailsService.build(UserBean.USER("0", "user", "{noop}user")));
        stringUserDetailsHashMap.put("admin", UserDetailsService.build(UserBean.CREATE("1", "admin", "{noop}admin", UserRole.ADMIN)));

        this.stringUserBeanHashMap = stringUserDetailsHashMap;
    }

    public UserDetails getUserByName(String name) {
        return stringUserBeanHashMap.getOrDefault(name, null);
    }
}
