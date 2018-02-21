package com.example.starting_spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArraysAndLoops {
    @PostMapping ("/lastThree")
    public List<String> lastThree(@RequestBody List<String> l) {
        return l.subList(l.size() -3, l.size());
    }
    @PostMapping ("/sumOFlist")
    public double sumOFlist(@RequestBody List<Double> l) {
        double sum = 0;
        for (int i = 0; i < l.size(); i++) {
            sum += l.get(i);
        }
        return sum;
    }
    @PostMapping ("/sumOFlonger")
    public List<Double> sumOFlonger(@RequestBody List<Double> l1, @RequestBody List<Double> l2) {
        if (l1.size() > l2.size()) {
            return l1;
        }
        return l2;
    }
    @PostMapping ("/differenceFromMinimum")
    public List<Double> differenceFromMinimum(@RequestBody List<Double> l) {
        List new_l = new ArrayList();
        for (int i = 0; i <  l.size(); i++) {
            new_l.add(2);
        }
        return new_l;
    }
}
