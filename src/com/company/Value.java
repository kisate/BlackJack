package com.company;

/**
 * Created by student3 on 10.11.16.
 */
public enum Value {
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
    Jack(10), Queen(10), King(10),
    Ace(11);

    int score;

    Value(int score) {
        this.score = score;
    }
}
