import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Card_Test
{
    Card newCard = new Card(Suit.HEARTS, 8);
    Card newCard2 = new Card(Suit.DIAMONDS, 4);
    Card faceCard = new Card(Suit.CLUBS, 11);
    Card aceCard = new Card(Suit.SPADES, 1);

    @Test
    void getSuit()
    {
        assertEquals(Suit.HEARTS, newCard.getSuit());
        assertEquals(Suit.DIAMONDS, newCard2.getSuit());
        assertEquals(Suit.CLUBS, faceCard.getSuit());
        assertEquals(Suit.SPADES, aceCard.getSuit());
    }
    @Test
    void setSuit()
    {
        newCard.setSuit(Suit.DIAMONDS);
        newCard2.setSuit(Suit.CLUBS);
        faceCard.setSuit(Suit.SPADES);
        aceCard.setSuit(Suit.HEARTS);

        assertEquals(Suit.DIAMONDS, newCard.getSuit());
        assertEquals(Suit.CLUBS, newCard2.getSuit());
        assertEquals(Suit.SPADES, faceCard.getSuit());
        assertEquals(Suit.HEARTS, aceCard.getSuit());
    }
    @Test
    void getRank()
    {
        assertEquals(8, newCard.getRank());
        assertEquals(4, newCard.getRank());
        assertEquals(11, newCard.getRank());
        assertEquals(1, newCard.getRank());
    }
    @Test
    void setRank()
    {
        newCard.setRank(9);
        newCard2.setRank(5);
        faceCard.setRank(12);

        assertEquals(9, newCard.getRank());
        assertEquals(5, newCard2.getRank());
        assertEquals(12, faceCard.getRank());
    }
    @Test
    void getValue()
    {
        assertEquals(newCard.getRank(), newCard.getValue());
        assertEquals(newCard2.getRank(), newCard2.getValue());
        assertEquals(10, faceCard.getValue());
        assertEquals(1, aceCard.getValue());
    }
    @Test
    void setValue()
    {
        newCard.setValue(8);
        newCard2.setValue(4);
        faceCard.setValue(11);

        assertEquals(8, newCard.getValue());
        assertEquals(4, newCard2.getValue());
        assertEquals(11, faceCard.getValue());

    }
    @Test
    void isAce()
    {
        assertFalse(newCard.isAce());
        assertFalse(newCard2.isAce());
        assertFalse(faceCard.isAce());
        assertTrue(aceCard.isAce());
    }
}