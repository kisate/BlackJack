package com.company;

import java.util.Scanner;

/**
 * Created by student3 on 23.11.16.
 */
public class HumanBetter extends Better{


    @Override
    public int makeBet(Player player) {
        int bet;
        do {
            System.out.println("Your points : " + player.points);
            System.out.println(player.name + ", please, make your bet");
            Scanner sc = Table.sc;
            bet = sc.nextInt();
            sc.nextLine();
            if (bet > player.points) System.out.println("Not enough points");
            else {
                if (bet <= 0) System.out.println("Your bet can`t be less or equals to zero");
                else break;
            }
        }   while(true);
        return bet;
    }
}
