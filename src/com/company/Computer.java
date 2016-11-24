package com.company;

import java.util.Random;

/**
 * Created by student3 on 10.11.16.
 */
public class Computer extends Player{
    public Computer(String name, int points) {
        this.intellect = new DealerIntellect();
        CompNames[] names = CompNames.values();
        CompNames2[] names2 = CompNames2.values();
        int x = (int)(Math.random()*names.length);
        int y = (int)(Math.random()*names2.length);
        this.name = names[x].toString() + " " + names2[y];
        this.points = points;
        this.better = new ComputerBetter();
    }
}
