package org.example;

import java.util.Objects;

public class Card {
    private String cardSuit;
    private String cardRank;

    public Card(String cardSuit, String cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;

    }

    public String getCardSuit() {
        return cardSuit;
    }

    public String getCardRank() {
        return cardRank;
    }

    public void setCardSuit(String cardSuit) {
        this.cardSuit = cardSuit;
    }

    public void setCardRank(String cardRank) {
        this.cardRank = cardRank;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardSuit, card.cardSuit) && Objects.equals(cardRank, card.cardRank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardSuit, cardRank);
    }
}
