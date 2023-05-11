package com.utsav.springcore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// Lazy used for..  not bean created until not needed otherwise it is always initialize
@Component
@Lazy
public class TrackCoach implements Coach{

    public TrackCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k....";
    }
}
