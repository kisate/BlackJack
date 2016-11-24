package com.company;

/**
 * Created by student3 on 23.11.16.
 */
public class ComputerBetter extends Better{
    @Override
    public int makeBet(Player player) {
        return player.points / 2;
    }
}
