package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by student3 on 23.11.16.
 */
public class Table {

    Dealer dealer;
    List<Player> players = new LinkedList<Player>();
    int humPlrs;
    static Scanner sc = Main.sc;

    public void init(){
        System.out.println("How many decks?");
        int decks = sc.nextInt();
        System.out.println("How many computer players?");
        int plNum = sc.nextInt();
        System.out.println("How many starting points?");
        int spts = sc.nextInt();
        System.out.println("How many human players?");
        humPlrs = sc.nextInt();
        sc.nextLine();
        dealer = new Dealer(decks);
        for (int i = 0; i < plNum; i++) {
            players.add(new Computer("Comp" + i, spts));
        }
        for (int i = 0; i < humPlrs; i++) {
            System.out.println("Player #" +  (i + 1) + " name?");
            String name = sc.nextLine();
            players.add(new Human(name, spts));
        }
        players.add(dealer);
    }

    public void play(){

        for (Player player : players) {
            if (player.state != PlayerStates.Bankrupt) {
                player.hand.clear();
                player.bet = player.better.makeBet(player);
                dealer.deal(player);
                dealer.deal(player);
            }
            else System.out.println(player.name + " : Bankrupt");
        }
        System.out.println("Dealer : " + dealer.hand.getScore() + " score, cards : " + dealer.hand);
        for (Player player: players) {

            if (player.state != PlayerStates.Bankrupt) {

                Command command;
                do {

                    System.out.println(player.name + " : points " + player.points + ", bet " + player.bet + ", score "
                            + player.hand.getScore() + ", cards : " + player.hand);
                    command = player.commands();
                    if(readCommand(player, command)) break;

                } while (command != Command.Stand);
            } else System.out.println(player.name + " : Bankrupt");
        }
        checkWinCondts();
    }

    public boolean readCommand(Player player, Command command){
        switch (command) {
            case Hit:
                dealer.deal(player);
                break;
            case Double :
                player.bet*= 2;
                dealer.deal(player);
                return true;
            case Split :
                break;
        }
        return false;
    }

    public void checkWinCondts(){
        for (Player player : players){
            if((player!=dealer) && (player.state != PlayerStates.Bankrupt)){
                if (player.hand.isOverDraft()) {
                    player.state = PlayerStates.Loss;
                    player.points -= player.bet;
                }
                else if ((player.hand.getScore() > dealer.hand.getScore()) || (dealer.hand.isOverDraft())) {
                    player.state = PlayerStates.Win;
                    player.points += player.bet;
                }
                else {
                    player.state = PlayerStates.Loss;
                    player.points -= player.bet;
                }
                if (player.points <= 0) player.state = PlayerStates.Bankrupt;
                if (player.state != PlayerStates.Bankrupt)
                    System.out.println(player.name + " : " + player.state + ", points : " + player.points + ", score " + player.hand.getScore()+ ", cards : " + player.hand);
            }

            if (player.state == PlayerStates.Bankrupt) {
                System.out.println(player.name + " : Bankrupt");
                if (player instanceof Human) humPlrs--;
            }
        }
        if (humPlrs == 0) {endGame(); return;}

        System.out.println();
        System.out.println("Begin new game?");
        String in = sc.nextLine();
        if ("no".startsWith(in)){endGame(); return;}

    }

    public void endGame() {
        System.exit(0);
    }
}
