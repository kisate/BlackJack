package com.company;

/**
 * Created by student3 on 10.11.16.
 */
public class Human extends Player{
    public Human(String name, int points) {
        this.name = name;
        this.points = points;
        this.intellect = new HumanIntellect();
        this.better = new HumanBetter();
    }
}
