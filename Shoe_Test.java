import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Shoe_Test
{
    private Shoe testShoe = new Shoe();
    private Card test_card = testShoe.deal();

    @Test
    void isShoeEmpty()
    {
        assertFalse(testShoe.isShoeEmpty());
    }
    @Test
    void deal()
    {
        assertNotEquals(null, test_card);
    }
    @Test
    void printCard()
    {
        testShoe.printCard(test_card);
    }
}