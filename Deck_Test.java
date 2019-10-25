import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Deck_Test
{
    private Deck testDeck = new Deck();

    @Test
    void Shuffle()
    {
        Card testCard1 = testDeck.dealCard();
        testDeck.Shuffle();
        Card testCard2 = testDeck.dealCard();
        testDeck.Shuffle();
        Card testCard3 = testDeck.dealCard();
        testDeck.Shuffle();
        Card testCard4 = testDeck.dealCard();
        testDeck.Shuffle();
        Card testCard5 = testDeck.dealCard();

        /*
        System.out.println(testCard1.getRank());
        System.out.println(testCard2.getRank());
        System.out.println(testCard3.getRank());
        System.out.println(testCard4.getRank());
        System.out.println(testCard5.getRank());
        System.out.println(testCard1.getSuit());
        System.out.println(testCard2.getSuit());
        System.out.println(testCard3.getSuit());
        System.out.println(testCard4.getSuit());
        System.out.println(testCard5.getSuit());
        System.out.println(testCard1.getValue());
        System.out.println(testCard2.getValue());
        System.out.println(testCard3.getValue());
        System.out.println(testCard4.getValue());
        System.out.println(testCard5.getValue());
         */

        assertNotEquals(testCard1.getRank(), testCard3.getRank());
    }
    @Test
    void dealCard()
    {
        testDeck.dealCard();
    }
}