import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Deck_Test
{
    private Deck testDeck = new Deck();

    @Test
    void Shuffle()
    {
        testDeck.Shuffle();
    }
    @Test
    void dealCard()
    {
        testDeck.dealCard();
    }
}