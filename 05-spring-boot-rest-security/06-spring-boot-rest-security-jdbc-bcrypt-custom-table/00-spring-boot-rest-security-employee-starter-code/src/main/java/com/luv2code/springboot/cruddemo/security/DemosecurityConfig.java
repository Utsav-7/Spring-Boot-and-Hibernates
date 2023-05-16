package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemosecurityConfig {


    // add support for JDBC ... no more hard coded users :-)
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(Configurer ->
                configurer
                        .requestMathcers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMathcers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMathcers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMathcers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMathcers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use HTTP Basic authentication
        http.httpBasic();
        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf().disable();

        return http.build();
    }

     /*
    @Bean
    public InMemoryUserDetailManager userDetailManager(){

        UserDetails john= User.builder()
                        .username("john")
                        .password("{noop}test123")
                        .roles("EMPLOYEE")
                        .build();

        UserDetails mary=User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan=User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailManager(john, mary, susan);
    }
    */
}
