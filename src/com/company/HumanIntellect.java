package com.company;

import java.util.Scanner;

/**
 * Created by student3 on 16.11.16.
 */
public class HumanIntellect extends Intellect{
    static Scanner in = Table.sc;

    @Override
    public Command think(int score) {
        if(score > 21)
            return Command.Stand;
        while (true) {
            System.out.println("hit/stand: ");
            String s = in.nextLine();
            if ("hit".startsWith(s)) {
                return Command.Hit;
            } else if ("stand".startsWith(s)) {
                return Command.Stand;
            } else {
                System.out.println("Command not recognized...");
            }
        }
    }
}
