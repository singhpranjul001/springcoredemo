package com.practice.springcoredemo.rest;

import com.practice.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



    /*// This is an example of field injection and we do not need constructors
    // or setter while using field injection however it is not recommended
    // as it makes the code harder to unit test

    @Autowired
    private Coach myCoach;
    */
    //setter injection
    /*@Autowired
    public void setCoach(Coach theCoach) {
        myCoach = theCoach;
    }*/

    //Qualifier annotation
    /*@Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    //define a constructor for dependency injection

    @RestController
    public class DemoController {
        //defining a private field for the dependency
        private Coach myCoach;
        private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach,
                          @Qualifier("trackCoach") Coach theAnotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
        public String checkScope(){
            return "Comparing beans's scope, " + (myCoach == anotherCoach);
        }
}
