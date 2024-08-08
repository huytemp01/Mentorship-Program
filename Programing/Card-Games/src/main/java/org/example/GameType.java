package org.example;

import java.util.Map;

public class GameType {
    private String name;
    private int maxPlayers ;
    private Map<Character, Integer> cardValues;

    private int numberOfCards;



    public void calculateValues(){

    }

    public GameType(String name, int maxPlayers, Map<Character, Integer> cardValues, int numberOfCards) {
        this.name = name;
        this.maxPlayers = maxPlayers;
        this.cardValues = cardValues;
        this.numberOfCards = numberOfCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Map<Character, Integer> getCardValues() {
        return cardValues;
    }

    public void setCardValues(Map<Character, Integer> cardValues) {
        this.cardValues = cardValues;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}
