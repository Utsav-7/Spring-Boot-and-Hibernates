package com.utsav.springcore.rest;

import com.utsav.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    @Autowired
    private Coach myCoach;

    // No need to define setter method or constuctor (Field Injection)
    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){

        return myCoach.getDailyWorkout();
    }


}
