import java.util.ArrayList;
import java.util.ListIterator;

public class Shoe
{
    private Deck currentDeck;
    private final int decksInAShoe = 8;
    private ArrayList<Deck> shoeOfDecks;
    private ListIterator<Deck> deckIterator;

    //Makes an arraylist containing all the decks
    //Uses an iterator to take out the latest deck, and assign it to currentDeck
    public Shoe()
    {
        shoeOfDecks = new ArrayList<Deck>(decksInAShoe);
        for (int i = 1; i <= decksInAShoe; i++){
            shoeOfDecks.add(new Deck());
        }
        deckIterator = shoeOfDecks.listIterator();
        currentDeck = deckIterator.next();
        deckIterator.remove();
    }

    public boolean isShoeEmpty()
    {
        if(deckIterator.hasNext())
            return false;
        else
            return true;
    }
//Returns a card from the deck, moves to next deck if deck is empty
    public Card deal(){
        if (currentDeck.getDeckSize() > 0)
            return currentDeck.dealCard();
        currentDeck = deckIterator.next();
        deckIterator.remove();
        return currentDeck.dealCard();
    }

   //Temporary testing methods
    void printCard(Card c){
        System.out.println(c.getRank() + " " + c. getSuit() +" " + c. getValue());
    }
    public static void main(String [] args){
        Shoe s1 = new Shoe();
        for (int i = 0; i < 20; i++){
            Card c = s1.deal();
            s1.printCard(c);
        }
    }
}