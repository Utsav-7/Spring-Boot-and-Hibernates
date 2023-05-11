package com.utsav.springcore.rest;

import com.utsav.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    // Specify the bean id: baseballCoach (Same name as class, first character lower-case)
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAntherCoach){
        System.out.println("In constructor: "+getClass().getSimpleName());
        myCoach=theCoach;
        anotherCoach=theAntherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){
        return myCoach.getDailyWorkout();
    }


    // By default, scope is singleton so that singleton = true
    //                                        prototype = false
    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myCoach == anotherCoach: "+ (myCoach == anotherCoach);
    }


}
