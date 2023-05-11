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
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach theCoach){
        myCoach=theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){
        return myCoach.getDailyWorkout();
    }


}
