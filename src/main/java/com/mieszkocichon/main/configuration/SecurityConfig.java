package com.mieszkocichon.main.configuration;

import com.mieszkocichon.main.enums.UserRole;
import com.mieszkocichon.main.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    // TODO delete?
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests()
                .antMatchers("/**").permitAll()
/*                .antMatchers(HttpMethod.GET, "/dashboard").hasRole(UserRole.USER.name())
                .antMatchers(HttpMethod.POST, "/dashboard").hasRole(UserRole.ADMIN.name())
                .antMatchers(HttpMethod.POST, "/dashboard/{id}").hasRole(UserRole.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/dashboard/{id}").hasRole(UserRole.ADMIN.name())
                .anyRequest().authenticated()*/.and()
                .httpBasic().and()
                .cors().disable()
                .csrf().disable();
    }
}
