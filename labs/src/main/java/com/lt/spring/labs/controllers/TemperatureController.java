package com.lt.spring.labs.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("temperature")
public class TemperatureController {
    private double scaled(double num, double
                                  scaleToMin, double scaleToMax, double currentMin,
                          double currentMax) {
        return (scaleToMax - scaleToMin)*(num -
                currentMin)/(currentMax-currentMin)+scaleToMin;
    }

    @GetMapping("")
    public  ResponseEntity<Integer> getTemperature(){
        double rand = Math.random() * 100;
        int temp = (int) scaled(rand, -15.0, 60, 0,
                100);
        return ResponseEntity.ok(temp);

    }

    @GetMapping("cel-to-fah/{celsius}")
    public ResponseEntity<Integer>
    convertCelsiusToFahrenheit(@PathVariable double
                                       celsius){
        System.out.println(celsius);
        Double result = (celsius * 9/5)+32;
        return ResponseEntity.ok(result.intValue());

    }


}
