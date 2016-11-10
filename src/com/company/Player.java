package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student3 on 10.11.16.
 */
public class Player {

    public List<Card> cards = new LinkedList<Card>();
    public int score = 0;

    public void countCards(){

        for (Card card: cards)
        {
            score+= card.cost;
        }
    }
}
