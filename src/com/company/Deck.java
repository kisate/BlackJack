package com.company;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by student3 on 10.11.16.
 */
public class Deck extends LinkedList<Card>{

    public Deck(int amount) {
        for (int i = 0; i < amount; i++) {

            for (Suit suit : Suit.values()) {
                for (Value value : Value.values()) {
                    this.add(new Card(suit, value));
                }
            }
        }
        Collections.shuffle(this);
    }


}
