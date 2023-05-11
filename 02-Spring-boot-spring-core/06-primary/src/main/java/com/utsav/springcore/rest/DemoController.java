package com.utsav.springcore.rest;

import com.utsav.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    private Coach myCoach;


    //No need of @Qualifiers because there is @Primary coach is CricketCoach
    @Autowired
    public DemoController(Coach theCoach){

        myCoach=theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){
        return myCoach.getDailyWorkout();
    }


}
