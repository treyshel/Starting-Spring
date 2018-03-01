package com.example.starting_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ObjectsController {
    @GetMapping("/readInventory")
    public HashMap readInventory(@RequestParam String readInv) {
        if (readInv.equals("")) {
            return new HashMap();
        }

        ArrayList<String> items = new ArrayList<>(Arrays.asList(readInv.split("\n")));
        HashMap<String, Items> product = new HashMap();
        for (int i = 0; i < items.size(); i++) {
            String[] arr = items.get(i).split("\t");
            String name = arr[0];
            double pay = Double.parseDouble(arr[1]);
            double charge = Double.parseDouble(arr[2]);
            Items item = new Items(name, pay, charge);
            product.put(name, item);
        }
        return product;
    }

    @PostMapping("/isDollarStore")
    public boolean isDollarStore(@RequestBody HashMap<String, Items> x){
        for (Items i: x.values()){
            if (i.charging > 1) {
                return false;
            }
        }
        return true;
    }

}


