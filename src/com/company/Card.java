package com.company;

/**
 * Created by student3 on 09.11.16.
 */
public class Card {
    Suit suit;
    Value value;
    int cost;

    Card (Suit _suit, Value _value)
    {
        suit = _suit;
        value = _value;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
