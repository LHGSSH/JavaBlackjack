public class Deck {

    private int nextCard;
    private Card deckOfCards[] = new Card[52];

    public Deck(){
    //Needs to be filled with loop to create deck array
    }
    /*
     This method will be filed, its just here for the UML and so it will compile for now
     */
    public Deck Shuffle(Deck deck){
        return deck;
    }
    /*
    This method will be filed, its just here for the UML and so it will compile for now
     */
    public Card dealCard(){
       Card card = new Card(Suit.HEARTS,3);
        return card;
    }
}
