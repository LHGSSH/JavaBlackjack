import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Card_Test_Case
{
    @org.junit.jupiter.api.Test
    void main()
    {
        System.out.println("Testing");
    }
    @Test
    public void testing()
    {
        Test_Case newTest = new Test_Case();

        assertEquals("Hello World!", newTest.getTestWord());
    }

    @Test
    public void testCard()
    {
        card newCard = new card();
        newCard.setSuit("Heart");
        newCard.setRank(8);
        newCard.isAce(False);
        newCard.isFace(False);

        card newCard2 = new card();
        newCard2.setSuit("Diamond");
        newCard2.setRank(4);
        newCard2.isAce(False);
        newCard2.isFace(False);

        card faceCard = new card();
        faceCard.setSuit("Club");
        faceCard.setRank(11);
        faceCard.isAce(False);
        faceCard.isFace(True);

        card aceCard = new card();
        aceCard.setSuit("Spade");
        aceCard.setRank(1);
        aceCard.isAce(True);
        aceCard.isFace(False);

        assertEquals("Heart", newCard.getSuit());
        assertEquals(8, newCard.getRank());
        assertEquals(False, newCard.isAce());
        assertEquals(False, newCard.isFace());

        assertEquals("Diamond", newCard2.getSuit());
        assertEquals(4, newCard2.getRank());
        assertEquals(False, newCard2.isAce());
        assertEquals(False, newCard2.isFace());

        assertEquals("Club", faceCard.getSuit());
        assertEquals(11, faceCard.getRank());
        assertEquals(False, faceCard.isAce());
        assertEquals(True, faceCard.isFace());

        assertEquals("Spade", aceCard.getSuit());
        assertEquals(1, aceCard.getRank());
        assertEquals(True, aceCard.isAce());
        assertEquals(False, aceCard.isFace());

    }
    /*
    @Test
    public void testShoe()
    {

    }
     */
}