package com.company;

import java.util.LinkedList;
import java.util.List;

import static com.company.Command.Hit;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Dealer dealer = new Dealer();
        List<Player> players = new LinkedList<Player>();

        players.add(new Computer("Comp1"));
        players.add(new Computer("Comp2"));
        players.add(new Computer("Comp3"));
        players.add(new Human("You"));
        players.add(dealer);

        for (Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
        }

        for (Player player: players) {
            Command command;
            do {
                System.out.println(player.name + " : score "
                        + player.hand.getScore()+ " cards : " + player.hand);
                command = player.commands();
                switch (command) {
                    case Hit:
                        dealer.deal(player);
                        break;
                }

            } while (command!=Command.Stand);
        }

        System.out.println("Dealer: "+dealer.hand.getScore()+" score with"+dealer.hand);

        for (Player player : players){
            if(player!=dealer){
                if (player.hand.isOverDraft())
                    player.state = PlayerStates.Loss;
                else if ((player.hand.getScore() > dealer.hand.getScore()) || (dealer.hand.isOverDraft()))
                    player.state = PlayerStates.Win;
                else
                    player.state = PlayerStates.Loss;

                System.out.println(player.name + " : " + player.state + " score " + player.hand.getScore()+ " cards : " + player.hand);
            }
        }
    }
}