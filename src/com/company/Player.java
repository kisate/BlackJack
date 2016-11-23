package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student3 on 10.11.16.
 */
public class Player {
    Hand hand = new Hand();
    public String name;
    public int bet, points;
    Intellect intellect;
    Better better;
    public PlayerStates state = PlayerStates.Loss;

    public void take(Card current) {
        this.hand.add(current);
    }

    public Command commands() {
        return this.intellect.think(this.hand.getScore());
    }



}
