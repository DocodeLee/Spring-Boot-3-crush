package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for : coach.name and team.name

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "TeamInfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }

    //expose "/" that return "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "get hard 5k!";
    }

    //expose a new endpoint for "practice"
    @GetMapping("/practice")
    public String praticeMean(){
        return "Practice makes perfect";
    }
    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String fortune(){
        return "I need fortune";
    }
}
