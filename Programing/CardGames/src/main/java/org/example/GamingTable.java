package org.example;

import java.util.*;

public class GamingTable {
    private Map<Player, List<Card>> playerCards;
    public void play(List<Player> players, GameType typeGame, Deck deck){
        dealTheCards(players, typeGame, deck);
//        determineWinner(players,typeGame);
    }

    public void dealTheCards(List<Player> players, GameType gameType, Deck deck) {
        if(gameType.getMaxPlayers() < players.size()){
            System.out.println("Error! The number of participants exceeded the number of players allowed for the game.");
            return;
        }
        // initialize Map to store player's cards.
        playerCards = new HashMap<>();
        setUpCardArea(players);
        // start to deal the cards
        Random rand = new Random();
        int numberOfCards = deck.getCards().size();
        for(int i = 0 ; i< gameType.getNumberOfCards(); i++){
            for(Player p:players){
                int value = rand.nextInt(numberOfCards) + 1;
                Card card = deck.getCardAt(value);
                giveCardToPlayer(p, card);
                numberOfCards -= 1;
            }
        }


    }

    private void setUpCardArea(List<Player> players) {
        for(Player p:players){
            playerCards.put(p, new ArrayList<>());
        }
    }

    private void giveCardToPlayer(Player p, Card card) {
        playerCards.get(p).add(card);
    }

    public Map<Player, List<Card>> getPlayerCards() {
        return playerCards;
    }
}
