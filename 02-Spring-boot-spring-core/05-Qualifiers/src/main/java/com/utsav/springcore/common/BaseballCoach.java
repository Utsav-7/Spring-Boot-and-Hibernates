package com.utsav.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return "Spend 30 minute in batting practice...";
    }
}
