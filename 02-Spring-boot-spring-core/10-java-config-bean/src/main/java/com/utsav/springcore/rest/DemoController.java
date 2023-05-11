package com.utsav.springcore.rest;

import com.utsav.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    private Coach myCoach;

    // Specify the bean id: baseballCoach (Same name as class, first character lower-case)
    // Here SwimCoach did not have @Component Instead, we configured as a Spring bean using @Bean in config/SportConfig
    // If you give any custom Bean id then write that custom Bean Id in Qualifier.
    @Autowired
    public DemoController(@Qualifier("swimCoach") Coach theCoach){
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){
        return myCoach.getDailyWorkout();
    }

}
