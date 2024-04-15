package com.practice.springcoredemo.rest;

import com.practice.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //defining a private field for the dependency
    private Coach myCoach;

    /*// This is an example of field injection and we do not need constructors
    // or setter while using field injection however it is not recommended
    // as it makes the code harder to unit test
    @Autowired
    private Coach myCoach;
    */

    /*@Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }*/

    //define a constructor for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
