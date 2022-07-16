package com.idhit.hms.idhithealthclinicclient.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/idhita/doctors/**").authenticated()
                .antMatchers("/idhita/doctors/**").hasAnyRole("ADMIN", "RECEP")
                .antMatchers("/idhita/doctors/register").authenticated()
                .antMatchers("/idhita/doctors/register").hasAnyRole("ROLE_ADMIN", "ROLE_PHARMA")
                .antMatchers("/idhita/doctors/{id}/**").authenticated()
                .antMatchers("/idhita/doctors/{id}/**").hasAnyRole("DOCTOR", "ADMIN", "RECEP")
                .antMatchers("/idhita/appointments/**").authenticated()
                .antMatchers("/idhita/appointments/**").hasAnyRole("ADMIN", "RECEP")
                .antMatchers("/idhita/medicines/**").authenticated()
                .antMatchers("/idhita/medicines/**").hasAnyRole("ADMIN", "PHARMA")
                .antMatchers("/idhita/pharma_home").authenticated()
                .antMatchers("/idhita/pharma_home").hasAnyRole("ADMIN", "PHARMA")
                .antMatchers("/idhita/recep_home").authenticated()
                .antMatchers("/idhita/recep_home").hasAnyRole("ADMIN", "RECEP")
                .antMatchers("/login").permitAll()
                .antMatchers("/register").authenticated()
                .antMatchers("/register").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("email")
                .defaultSuccessUrl("/idhita/redirect")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/idhita/").permitAll();
    }


}
