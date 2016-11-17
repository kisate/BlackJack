package com.company;

/**
 * Created by student3 on 10.11.16.
 */
public class Computer extends Player{
    public Computer(String name, int points) {
        this.intellect = new DealerIntellect();
        this.name = name;
        this.points = points;
    }
}
