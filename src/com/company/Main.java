package com.company;

import java.util.LinkedList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Card> deck = new LinkedList<Card>();

        for (Suit suit: Suit.values()) {
            for (Value value: Value.values()) {
                deck.add(new Card(suit, value));
            }
        }
    }
}
