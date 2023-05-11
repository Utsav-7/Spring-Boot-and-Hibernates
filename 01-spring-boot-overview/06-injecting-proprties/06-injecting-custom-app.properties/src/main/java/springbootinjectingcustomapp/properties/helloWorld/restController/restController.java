package springbootinjectingcustomapp.properties.helloWorld.restController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose details of coachname and teamname
    @GetMapping("/getDetails")
    public String getDetails(){
        return "Coach Name: "+coachName+", Team Name: "+teamName;
    }
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
