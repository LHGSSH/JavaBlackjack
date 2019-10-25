public class Shoe
{
    private Deck deck01;
    private Deck deck02;
    private Deck deck03;
    private Deck deck04;
    private Deck deck05;
    private Deck deck06;
    private Deck deck07;
    private Deck deck08;
    private Deck currentDeck;
    private int decksRemaining;

    public Shoe()
    {
        this.deck01 = Deck();
        this.deck02 = Deck();
        this.deck03 = Deck();
        this.deck04 = Deck();
        this.deck05 = Deck();
        this.deck06 = Deck();
        this.deck07 = Deck();
        this.deck08 = Deck();

        this.currentDeck = this.deck01;

        this.decksRemaining = 8;
    }

    public boolean isShoeEmpty()
    {
        if(decksRemaining >= 1)
            return false;
        else
            return true;
    }

    public Card deal(Deck currentDeck)
    {
        // Presumed that dealCard method exists within Deck class
        return currentDeck.dealCard();
    }

}