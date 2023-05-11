package com.utsav.springcore.common;

import org.springframework.stereotype.Component;

// @Component annotation marks the class as a spring bean
// Prototype scope: New object instance for each injection
@Component
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minute...";
    }

}
