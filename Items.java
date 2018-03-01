package com.example.starting_spring;

public class Items {
    //declaring the type
    public String item;
    public Double price;
    public Double charging;

    //constructor..."__init__"
    public Items() {}
    public Items(String item, Double price, Double charging) {
        this.item = item;
        this.price = price;
        this.charging = charging;
    }
}
