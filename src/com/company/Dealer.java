package com.company;

/**
 * Created by student3 on 10.11.16.
 */
public class Dealer extends Computer{
    Deck deck;
    Better better = new NullBetter();
    Dealer(int decks){
        super("Dealer", 0);
        this.intellect = new DealerIntellect();
        this.deck = new Deck(decks);
        name = "Dealer";
    }

    public void deal(Player player) {
        Card current = this.deck.pop();
        player.take(current);
    }
}
