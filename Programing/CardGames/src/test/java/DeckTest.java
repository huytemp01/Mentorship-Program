import org.example.Card;
import org.example.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckTest {
    @Test
    public void test_deck_should_have_52Cards(){
        int expected = 52;
        int actual = 0;
        Deck deck = new Deck();
        actual = deck.getCards().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test_cards_are_different (){
        boolean isDifferent = false;
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        Set<Card> cardSet = new HashSet<>();
        for(Card c : cards){
            isDifferent = cardSet.add(c);
            if(!isDifferent){
                break;
            }
        }
        Assert.assertTrue(isDifferent);
    }

    @Test
    public void test_all_cards_should_validate(){
        boolean isValidate = false;
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] suits = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};

        ArrayList<Card> expected = new ArrayList<>();
        List<Card> actual = new Deck().getCards();
        for (String suit : suits) {
            for (String rank : ranks) {
                isValidate = actual.contains(new Card(suit,rank));
                if(isValidate == false){
                    break;
                }
            }
        }
        Assert.assertTrue(isValidate);
    }




}
