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
    /*
    @Test
    public void testCard()
    {

    }
    @Test
    public void testShoe()
    {

    }
     */
}