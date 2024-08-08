import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GamingTableTest {
    @Test
    public void testDealTheCardForCaoBaLa(){
        GamingTable gamingTable = new GamingTable();
        // create list of players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Huy"));
        players.add(new Player("Minh"));
        players.add(new Player("Vinh"));
        // create game type and its rules
        GameType gameType = new GameType("Cao 3 la", 17, null, 3);
        //create a Deck of 52 cards
        Deck deck = new Deck();
        // Verify that dealTheCards works correctly based on gameType, players, and deck.
        gamingTable.dealTheCards(players,gameType, deck);
        Map<Player, List<Card>> playerCards = gamingTable.getPlayerCards();
        // Game type is Bài cào 3 lá. so each Player will have 3 cards.
        int actualCardsOfPlayers = 0;
        int expectedCardsOfPlayers = 9;
        for(Player p:playerCards.keySet()){
            actualCardsOfPlayers += playerCards.get(p).size();
        }
        Assert.assertEquals(actualCardsOfPlayers,expectedCardsOfPlayers);
    }

    @Test
    public void testDealTheCardForThirteen(){
        GamingTable gamingTable = new GamingTable();
        // create list of players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Huy"));
        players.add(new Player("Minh"));
        players.add(new Player("Vinh"));
        // create game type : Thirteen (tiến lên) and its rules
        GameType gameType = new GameType("Tiến lên", 4, null, 13);
        //create a Deck of 52 cards
        Deck deck = new Deck();
        // Verify that dealTheCards works correctly based on gameType, players, and deck.
        gamingTable.dealTheCards(players,gameType, deck);
        Map<Player, List<Card>> playerCards = gamingTable.getPlayerCards();
        // Game type is Tiến Lên. so each Player will have 13 cards.
        int actualCardsOfPlayers = 0;
        int expectedCardsOfPlayers = 39;
        for(Player p:playerCards.keySet()){
            actualCardsOfPlayers += playerCards.get(p).size();
        }
        Assert.assertEquals(actualCardsOfPlayers,expectedCardsOfPlayers);
    }

    @Test
    public void testMaximunNumberofPlayers(){

    }

    @Test
    public void testCardQuantityPerPlayers(){

    }

    @Test
    public void testCalculateCardPoints(){

    }

    @Test
    public void testDetermineWiner(){

    }


}
