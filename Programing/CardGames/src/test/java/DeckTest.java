import org.example.Card;
import org.example.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DeckTest {
    @Test
    public void testDeckContainCard(){
        // Determine if the card is in the deck.
        Card card = new Card("J","HEARTS");
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();
        for(Card c:cards){
            if(c.equals(card)){
                Assert.assertEquals(c, card);
            }
        }
    }

    @Test
    public void testCardsDuplicated(){

    }




}
