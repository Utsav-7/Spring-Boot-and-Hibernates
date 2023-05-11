package springbootinjectingcustomapp.properties.helloWorld.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    // expose "/" that return "Hello World"
    @GetMapping("/")
    public String helloWorld(){

        return "Hello World!";
    }

}
