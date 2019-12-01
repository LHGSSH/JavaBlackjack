import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Deck_Test
{
    private Deck testDeck = new Deck();

    @Test
    void dealCard()
    {
        int deckSizeBefore = testDeck.getDeckSize();

        Card dealCardTestCard = testDeck.dealCard();

        int deckSizeAfter = testDeck.getDeckSize();

        assertNotEquals(deckSizeBefore, deckSizeAfter);
        assertNotEquals(dealCardTestCard, null);

        Card testCard1 = testDeck.dealCard();
        Card testCard2 = testDeck.dealCard();

        assertNotEquals(testCard1.getRank(), testCard2.getRank());
    }
}