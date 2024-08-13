package org.example;

import java.util.*;

public class GameController {
    private Map<Player, List<Card>> playerCards;
    public void play(List<Player> players, GameType typeGame, Deck deck){
        dealTheCards(players, typeGame, deck);
        determineWinner(playerCards,typeGame);
    }

    public void dealTheCards(List<Player> players, GameType gameType, Deck deck) {
        if(!gameType.validateQuantityPlayers(players.size())){
            System.out.println("Error! The number of participants exceeded the number of players allowed for the game.");
            return;
        }
        // initialize Map to store player's cards.
        playerCards = new HashMap<>();
        setUpCardArea(players);
        // start to deal the cards
        Random rand = new Random();
        int numberOfCards = deck.getCards().size();
        int cardsPerPlayer = gameType.getNumberOfCards();
        for(int i = 0; i <cardsPerPlayer; i++ ){
            for(Player p:players){
                int value = rand.nextInt(numberOfCards);
                Card card = deck.getCardAt(value);
                giveCardToPlayer(p, card);
                deck.getCards().remove(value);
                numberOfCards--;
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

    public List<Player> determineWinner(Map<Player, List<Card>> cardplayer, GameType gameType) {
        List<Player> winners = new ArrayList<>();
        Map<Player, Integer> pointResult = calculatePointsAllPlayers(cardplayer, gameType);
        Player winner = new Player();
        for(Player p:pointResult.keySet()){
             winner = max(winner, p, pointResult);
        }

        for(Player p:pointResult.keySet()  ){
            if(pointResult.get(p) == pointResult.get(winner)){
                winners.add(p);
            }
        }

        return winners;
    }

    private Player max(Player p1, Player p2, Map<Player, Integer> pointResult) {
        int point1;
        int point2;
        if(pointResult.get(p1) == null){
            point1 = 0;
        }
        else{
            point1 = pointResult.get(p1);
        }
        if(pointResult.get(p2) == null){
            point2 = 0;
        }
        else{
            point2 = pointResult.get(p2);
        }

        if(point1 > point2){
            return p1;
        }
        return p2;

    }


    private static Map<Player, Integer> calculatePointsAllPlayers(Map<Player, List<Card>> cardplayer, GameType gameType) {
        Map<Player, Integer> playerPoints = new HashMap<>();
        for(Player p: cardplayer.keySet()){
            int points = gameType.calculateValues(cardplayer.get(p));
            playerPoints.put(p,points);
        }

        return playerPoints;
    }
}
