package com.idhit.hms.idhithealthclinicclient.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/idhita/login")
                .permitAll();
        http.logout().logoutUrl("/idhita/logout").logoutSuccessUrl("/idhita/hello");
    }
}
