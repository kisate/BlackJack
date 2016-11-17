package com.company;

/**
 * Created by student3 on 10.11.16.
 */
public class Human extends Player{
    public Human(String name) {
        this.name = name;
        this.intellect = new HumanIntellect();
    }
}
