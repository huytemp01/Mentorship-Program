package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GameType {
    private String name;
    private int maxPlayers ;
    private Map<String, Integer> cardValues;

    private int numberOfCards;

    public static boolean isTreeFaces(String cardRank1, String cardRank2, String cardRank3) {
        return isFace(cardRank1) && isFace(cardRank2) && isFace(cardRank3);

    }

    public static boolean isFace(String cardRank){
        Set<String> faces = new HashSet<>();
        faces.add("K");
        faces.add("Q");
        faces.add("J");

        boolean result = faces.contains(cardRank);
        return result;
    }

    public int calculateValues(List<Card> cardList){
        if(isTreeFaces(cardList.get(0).getCardRank(), cardList.get(1).getCardRank(), cardList.get(2).getCardRank())){
            return 100;
        }

        int result = 0;
        for(Card c:cardList){
            String rank = c.getCardRank();
            result += cardValues.get(rank);
        }
        result = result % 10;
        return result;
    }

    public GameType(String name, int maxPlayers, Map<String, Integer> cardValues, int numberOfCards) {
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

    public Map<String, Integer> getCardValues() {
        return cardValues;
    }

    public void setCardValues(Map<String, Integer> cardValues) {
        this.cardValues = cardValues;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public boolean validateQuantityPlayers(int players){
        return maxPlayers >= players;
    }
}
