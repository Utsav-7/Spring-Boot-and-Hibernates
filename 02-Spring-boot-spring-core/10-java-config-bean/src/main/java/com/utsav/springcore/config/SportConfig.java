package com.utsav.springcore.config;

import com.utsav.springcore.common.Coach;
import com.utsav.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // Here we manually handling construction of given coach
    // The bean Id defaults to the method name with first lower case letter
    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
