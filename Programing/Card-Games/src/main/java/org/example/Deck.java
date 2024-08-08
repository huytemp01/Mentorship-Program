package org.example;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        String[] cardSuit = new String[]{"SPADES","HEARTS","DIAMONDS","CLUBS"};
        String[] cardRank = new String[]{"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
        cards = new ArrayList<>();
        for(String i:cardRank){
            for(String j:cardSuit){
                Card card = new Card(j,i);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Card getCardAt(int value) {
        return cards.get(value);
    }
}
