package com.example.starting_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicsController {
    @GetMapping ("/add")
    public double addNumbers(@RequestParam double x, @RequestParam double y) {
        return x + y;
    }
    @GetMapping ("/double")
    public double doubleNumber(@RequestParam double x) {
        return x * 2;
    }
    @GetMapping ("/multThree")
    public double multThree(@RequestParam double x, @RequestParam double y, @RequestParam double z) {
        return x * y * z;
    }
    @GetMapping ("/totalEarnings")
    public double totalEarnings(@RequestParam double a, @RequestParam double b, @RequestParam double c) {
        return (a * 15) + (b * 12) + (c * 9);
    }
    @GetMapping ("/both")
    public boolean both(@RequestParam boolean x, @RequestParam boolean y) {
        if ((x && y) == true) {
            return true;
        }
        return false;
    }
    @GetMapping ("/walkORdrive")
    public String walkORdrive(@RequestParam double miles, @RequestParam boolean isNiceWeather) {
        if ((isNiceWeather == true) && (miles >= .25)) {
            return "Walk";
        }
        return "Drive";
    }
    @GetMapping ("/howPopulated")
    public String denselyORsparsely(@RequestParam double population, @RequestParam double landArea) {
        if ((population / landArea) >= 100) {
            return "Densely Populated";
        }
        return "Sparsely Populated";
    }
    @GetMapping ("/goldStars")
    public String starsANDpoints(@RequestParam double points) {
        if ((points) > 1000) {
            return "*";
        } else if ((points) > 5000) {
            return "**";
        } else if ((points) > 8000) {
            return "***";
        } else if ((points) > 10000) {
            return "****";
        }
        return "*****";
    }
    @GetMapping ("/howManyPoints")
    public String scoringAction(@RequestParam String action) {
        if ((action).toLowerCase().equals("touchdown")) {
            return "6 points";
        } else if ((action).toLowerCase().equals("field goal")) {
            return "3 points";
        } else if ((action).toLowerCase().equals("safety")) {
            return "2 points";
        } else if ((action).toLowerCase().equals("two point conversion")) {
            return "2 points";
        } else if ((action).toLowerCase().equals("field goal conversion")) {
            return "1 points";
        }
        return "invalid action";
    }
}