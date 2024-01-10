package com.example.myFirstProject;

import org.springframework.stereotype.Component;

@Component
public class Engine {

    public Engine() {
        System.out.println("engine started");
    }

    public void go(){
        System.out.println("go");
    }

}
