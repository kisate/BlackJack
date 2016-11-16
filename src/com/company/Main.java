package com.company;

import java.util.LinkedList;
import java.util.List;

import static com.company.Command.Hit;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Dealer dealer = new Dealer();
        List<Player> players = new LinkedList<Player>();

        players.add(new Computer());
        players.add(new Computer());
        players.add(new Computer());
        players.add(new Human());
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
        }

        for (Player player: players) {
            Command command;
            do {
                System.out.println(""+player.hand.getScore()+": " + player.hand);
                command = player.commands();
                switch (command) {
                    case Hit:
                        dealer.deal(player);
                        break;
                }

            } while (command!=Command.Stand);
        }
    }
}