package com.HelloWorld.HelloWorld.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getWorkout(){
        return "Run a hard 5k...";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day...";
    }
}
