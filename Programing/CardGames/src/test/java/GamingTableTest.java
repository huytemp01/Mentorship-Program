import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GamingTableTest {
    @Test
    public void test_deal_theCard_for_caoBaLa(){
        GameController gamingTable = new GameController();
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
    public void test_deal_theCar_forThirteen(){
        GameController gamingTable = new GameController();
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
    public void test_Quantity_Players_Should_Validate_onCao3La(){
        boolean isValidate = false;
        int players = 5;
        GameType gameType = new GameType("cao 3 la", 17, null, 3);
        isValidate = gameType.validateQuantityPlayers(players);
        Assert.assertTrue(isValidate);
    }

    @Test
    public void test_cards_of_each_player_should_different(){
        boolean isDifferent = false;

        GameController gamingTable = new GameController();
        // create list of players
        List<Player> players = new ArrayList<>();
        players.add(new Player("Huy"));
        players.add(new Player("Minh"));
        players.add(new Player("Vinh"));
        players.add(new Player("Tuan"));
        // create game type : Thirteen (tiến lên) and its rules
        GameType gameType = new GameType("Tiến lên", 4, null, 13);
        //create a Deck of 52 cards
        Deck deck = new Deck();
        // Verify that dealTheCards works correctly based on gameType, players, and deck.
        gamingTable.dealTheCards(players,gameType, deck);
        Map<Player, List<Card>> playerCards = gamingTable.getPlayerCards();
        List<Card> listCards = playerCards.get(players.get(0));
        Set<Card> setCards = new HashSet<>();
        for(Card c:listCards){
            isDifferent = setCards.add(c);
            if(!isDifferent){
                break;
            }
        }
        Assert.assertTrue(isDifferent);
    }

    @Test
    public void test_calculate_points_in_Cao3La(){
        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("DIAMONDS","2"));
        cards.add(new Card("DIAMONDS","5"));
        cards.add(new Card("DIAMONDS","A"));
        int actual = gameType.calculateValues(cards);
        int expected = 8;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test_calculate_points_in_Cao3La_2(){
        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("DIAMONDS","7"));
        cards.add(new Card("DIAMONDS","5"));
        cards.add(new Card("DIAMONDS","A"));
        int actual = gameType.calculateValues(cards);
        int expected = 3;
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void test_calculate_points_in_Cao3La_Tree_Faces(){
        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("DIAMONDS","J"));
        cards.add(new Card("DIAMONDS","Q"));
        cards.add(new Card("DIAMONDS","K"));
        int actual = gameType.calculateValues(cards);
        int expected = 100;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void test_tree_faces(){
        boolean result = GameType.isTreeFaces("K","K","J");
        Assert.assertTrue(result);
    }

    @Test
    public void test_Determine_Winer_Should_Have_3_Winners(){
        Map<Player, List<Card>> cardplayer = new HashMap<>();
        Player p1 = new Player("Huy");
        List<Card> l1 = new ArrayList<>();
        l1.add(new Card("SPADES","A"));
        l1.add(new Card("SPADES","5"));
        l1.add(new Card("SPADES","2"));
        Player p2 = new Player("Minh");
        List<Card> l2 = new ArrayList<>();
        l2.add(new Card("HEARTS","A"));
        l2.add(new Card("HEARTS","5"));
        l2.add(new Card("HEARTS","2"));
        Player p3 = new Player("Vinh");
        List<Card> l3 = new ArrayList<>();
        l3.add(new Card("DIAMONDS","A"));
        l3.add(new Card("DIAMONDS","5"));
        l3.add(new Card("DIAMONDS","2"));

        cardplayer.put(p1,l1);
        cardplayer.put(p2,l2);
        cardplayer.put(p3,l3);

        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);

        GameController gameController = new GameController();
        List<Player> winners =  gameController.determineWinner(cardplayer, gameType);
        int expected = 3;
        int actual = winners.size();
        Assert.assertEquals(expected,actual);


    }
    @Test
    public void test_Determine_Winer_Should_Have_2_Winners(){
        Map<Player, List<Card>> cardplayer = new HashMap<>();
        Player p1 = new Player("Huy");
        List<Card> l1 = new ArrayList<>();
        l1.add(new Card("SPADES","A"));
        l1.add(new Card("SPADES","5"));
        l1.add(new Card("SPADES","2"));
        Player p2 = new Player("Minh");
        List<Card> l2 = new ArrayList<>();
        l2.add(new Card("HEARTS","4"));
        l2.add(new Card("HEARTS","5"));
        l2.add(new Card("HEARTS","10"));
        Player p3 = new Player("Vinh");
        List<Card> l3 = new ArrayList<>();
        l3.add(new Card("DIAMONDS","10"));
        l3.add(new Card("DIAMONDS","5"));
        l3.add(new Card("DIAMONDS","4"));

        cardplayer.put(p1,l1);
        cardplayer.put(p2,l2);
        cardplayer.put(p3,l3);

        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);

        GameController gameController = new GameController();
        List<Player> winners =  gameController.determineWinner(cardplayer, gameType);
        int expected = 2;
        int actual = winners.size();
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void test_Determine_Winer_Should_Have_1_Winner(){
        Map<Player, List<Card>> cardplayer = new HashMap<>();
        Player p1 = new Player("Huy");
        List<Card> l1 = new ArrayList<>();
        l1.add(new Card("SPADES","A"));
        l1.add(new Card("SPADES","5"));
        l1.add(new Card("SPADES","2"));
        Player p2 = new Player("Minh");
        List<Card> l2 = new ArrayList<>();
        l2.add(new Card("HEARTS","K"));
        l2.add(new Card("HEARTS","Q"));
        l2.add(new Card("HEARTS","10"));
        Player p3 = new Player("Vinh");
        List<Card> l3 = new ArrayList<>();
        l3.add(new Card("DIAMONDS","K"));
        l3.add(new Card("DIAMONDS","J"));
        l3.add(new Card("DIAMONDS","Q"));

        cardplayer.put(p1,l1);
        cardplayer.put(p2,l2);
        cardplayer.put(p3,l3);

        Map<String, Integer> cardValues = new HashMap<>();
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for(String str:ranks){
            if(str.equals("A")){
                cardValues.put(str, 1);
            }
            else if(str.equals("J") || str.equals("Q") || str.equals("K")){
                cardValues.put(str, 10);
            }
            else{
                cardValues.put(str, Integer.valueOf(str));
            }
        }
        GameType gameType =new GameType("cao 3 la", 17, cardValues, 3);

        GameController gameController = new GameController();
        List<Player> winners =  gameController.determineWinner(cardplayer, gameType);
        int expected = 1;
        int actual = winners.size();
        Assert.assertEquals(expected,actual);


    }
}
