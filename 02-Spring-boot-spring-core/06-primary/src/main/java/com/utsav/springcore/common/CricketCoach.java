package com.utsav.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component annotation marks the class as a spring bean
// @Primary is set your primary bean
@Component
@Primary
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){

        return "Practice fast bowling for 15 minute...";
    }

}
