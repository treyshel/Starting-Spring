package com.example.starting_spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ArraysAndLoops {
    @PostMapping ("/lastThree")
    public List lastThree(@RequestBody List l) {
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
    @GetMapping ("/sumOFlonger")
    public double sumOFlonger(@RequestParam List<Double> l1, @RequestParam List<Double> l2) {
        if (l1.size() > l2.size()) {
            return sumOFlist(l1);
        } else if (l1.size() < l2.size()){
            return sumOFlist(l2);
        } else
            return sumOFlist(l1) + sumOFlist(l2);
    }
    @GetMapping ("/differenceFromMinimum")
    public ArrayList<Integer> differenceFromMinimum(@RequestParam ArrayList<Integer> l) {
        int minValue = Collections.min(l);

        for (int i = 0; i <  l.size(); i++) {
            int fixedL = (l.get(i) - minValue);
            l.set(i, fixedL);
    }
    return l;
    }
    @GetMapping ("/hashtags")
    public String hashtagsInPost(@RequestParam String tweet) {
        String[] hashtag = tweet.split(" ");
        String result = "";
        for (int x = 0; x < hashtag.length; x++) {
            if (hashtag[x].startsWith("#")) {
                result += " " + hashtag[x];
            }
        }
        return result.trim();
    }
    @GetMapping ("/mentions")
    public String mentionedInPost(@RequestParam String tweet) {
        String[] mentionedAt = tweet.split(" ");
        String result = "";
        for (int x = 0; x < mentionedAt.length; x++) {
            if (mentionedAt[x].startsWith("@")) {
                result += " " + mentionedAt[x];
            }
        }
        return result.trim();
    }
}
