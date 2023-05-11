package com.utsav.springcore.rest;

import com.utsav.util.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoController {
    //---------Step:3 define a private field for the dependency
    private Coach myCoach;

    // @Autowired annotation tells Spring to inject a dependency
    // If you only have one constructor then @Autowired on constructor is optional
    @Autowired
    public DemoController(Coach theCoach){
        myCoach=theCoach;
    }

    //---------Step:4 Add GetMapping for /dailyWorkout
    @GetMapping("/dailyWorkout")
    public String getDailWorkout(){
        return myCoach.getDailyWorkout();
    }


}
