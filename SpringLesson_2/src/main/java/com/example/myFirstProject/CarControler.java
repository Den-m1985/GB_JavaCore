package com.example.myFirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarControler {
    @Autowired
    Car car;

    @GetMapping("/car")
    public String startCar() {
        car.start();
        return "Car started";
    }
}
