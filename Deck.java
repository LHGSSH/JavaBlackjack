/**
 * This class represents a Deck of Card objects using an ArrayList and contains
 * methods to shuffle and deal the cards
 * 
 * @author Joshua Kleine
 * @version 1.0
 * 
 * CEN3031    Project
 * File Name: Deck.java
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Deck {

    private int nextCard;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>(52);

    //Two loops to create all 52 cards. The inner loop is complicated, but allows for this
    //code to hold even for changes in the size of a deck or types of suits.
    public Deck(){
      for (Suit suit : Suit.values()){
            for (int i = 0; i <= (deckOfCards.size() / Suit.values().length); i++){
                Card card = new Card(suit, i);
                deckOfCards.add(card);
            }
      }
    }
    /*
     This method mixes the ArrayList of Cards. It was modified to not return the deck.
     */
    public void Shuffle(){
        Collections.shuffle(deckOfCards);
    }
    /*
    If there is another card in the deck, this method returns it.
    Else, it returns null.
    (either in this class or in the manager class)
    */
    public Card dealCard(){
        ListIterator<Card> cardIterator = deckOfCards.listIterator();
        Card returnedCard;

        if (cardIterator.hasNext()) {
            returnedCard = cardIterator.next();
            cardIterator.remove();
            return returnedCard;
        }
        else {
            return null;
        }
    }
}
