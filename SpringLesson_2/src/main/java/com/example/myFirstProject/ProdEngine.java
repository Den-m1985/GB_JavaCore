package com.example.myFirstProject;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEngine implements Engine{


    public ProdEngine() {
        System.out.println("server engine started");
    }
    public void go(){
        System.out.println("go fast");
    }

}
