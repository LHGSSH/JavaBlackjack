import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Deck_Test
{
    private Deck testDeck = new Deck();

    @Test
    void Shuffle()
    {
        System.out.println("Deck Size: " + testDeck.getDeckSize());

        Card testCard1 = testDeck.dealCard();
        //testDeck.Shuffle();
        System.out.println("Deck Size: " + testDeck.getDeckSize());
        Card testCard2 = testDeck.dealCard();
        //testDeck.Shuffle();
        System.out.println("Deck Size: " + testDeck.getDeckSize());
        Card testCard3 = testDeck.dealCard();
        //testDeck.Shuffle();
        System.out.println("Deck Size: " + testDeck.getDeckSize());
        Card testCard4 = testDeck.dealCard();
        //testDeck.Shuffle();
        System.out.println("Deck Size: " + testDeck.getDeckSize());
        Card testCard5 = testDeck.dealCard();


        System.out.println("Test Card 1 Rank: " + testCard1.getRank());
        System.out.println("Test Card 2 Rank: " + testCard2.getRank());
        System.out.println("Test Card 3 Rank: " + testCard3.getRank());
        System.out.println("Test Card 4 Rank: " + testCard4.getRank());
        System.out.println("Test Card 5 Rank: " + testCard5.getRank());
        System.out.println("Test Card 1 Suit: " + testCard1.getSuit());
        System.out.println("Test Card 2 Suit: " + testCard2.getSuit());
        System.out.println("Test Card 3 Suit: " + testCard3.getSuit());
        System.out.println("Test Card 4 Suit: " + testCard4.getSuit());
        System.out.println("Test Card 5 Suit: " + testCard5.getSuit());
        System.out.println("Test Card 1 Value: " + testCard1.getValue());
        System.out.println("Test Card 2 Value: " + testCard2.getValue());
        System.out.println("Test Card 3 Value: " + testCard3.getValue());
        System.out.println("Test Card 4 Value: " + testCard4.getValue());
        System.out.println("Test Card 5 Value: " + testCard5.getValue());


        assertNotEquals(testCard1.getRank(), testCard3.getRank());
    }
    @Test
    void dealCard()
    {
        testDeck.dealCard();
    }
}