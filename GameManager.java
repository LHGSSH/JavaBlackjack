/*
This class provides the logic for the Blackjack game.
@version 1.0
CEN 3031
File: GameManager.java
*/
public class GameManager {

    static Shoe s1;
    ChipCount chips;
    static int dealerTotal, userTotal;
    //The score a new User gets
    int startingChips = 100;
    static Deck userHand;
    static Deck dealerHand;
    //TODO: handle if the shoe is empty before dealing by creating a new shoe
    //New game manager is created every time the entire game restarts, not between hands
    //Landing must allow user to log in (can just let them put in username and password
    // and make new user if not found in file.
    public GameManager(){
        s1 = new Shoe();
        userHand = new Deck(0);
        dealerHand = new Deck(0);
        chips = new ChipCount(startingChips);

        startGame();
    }

    //Returns the next card and adds its value to the user's total.
    // Moves to next deck, otherwise.
    public Card hit(){
        Card dealtCard;

        if (s1.isShoeEmpty()){
            s1 = new Shoe();
        }
        dealtCard = s1.deal();

        if (dealtCard.getRank() == 1) { //If the card is an ace
            if ( (userTotal + 11) < 21) { //If having the ace as an 11 doesn't push the user over 21
                dealtCard.setValue(11);
            }
            //Else, ace card already has a value of 1, so we keep it that way
        }

        userHand.deckOfCards.add(dealtCard);
        userTotal += dealtCard.getValue();
        return userHand.dealCard();
    }
    
    public boolean bet(int betAmount){
        //TODO needs logic, this is just so it will compile
        return true;
    }
    
    public void stay(){
        //TODO needs logic, this is just so it will compile
        dealerMove(dealerTotal);
    }

    public void endGame(ChipCount chips){
        //save the chip count to the user score
    }

    public void startGame(){
        userHand.deckOfCards.add(s1.deal());
        userTotal = userHand.deckOfCards.get(0).getValue();
        //System.out.println("First User Card Value: " + userTotal);

        userHand.deckOfCards.add(s1.deal());
        userTotal += userHand.deckOfCards.get(1).getValue();
        System.out.println("User Hand Value: " + userTotal);

        dealerHand.deckOfCards.add(s1.deal());
        dealerTotal = dealerHand.deckOfCards.get(0).getValue();
        //System.out.println("First Dealer Card Value: " + dealerTotal);

        dealerHand.deckOfCards.add(s1.deal());
        dealerTotal += dealerHand.deckOfCards.get(1).getValue();
        System.out.println("Dealer Hand Value: " + dealerTotal);
    }
    public void updateHand(){
        //may interact with landing
    }
    public boolean isBust(int total){
        if (userTotal > 21){
            return true;
        }
        return false;
    }
    public boolean isRoundOver(){

        return false;
    }
    public static void dealerMove(int currentScore){
        Card dealtCard;
        while (currentScore < 17) 
        {
            dealtCard = s1.deal();
            dealerTotal += dealtCard.getValue();
            dealerHand.deckOfCards.add(dealtCard);
            currentScore = dealerTotal;
            
            System.out.println("Dealer Total: " + currentScore);
        }
        
        System.out.println("Final Dealer Total: " + dealerTotal);
        
        if (dealerTotal > 21)
        	System.out.println("Dealer BUSTS!");
        else if ((dealerTotal <= 21) && (dealerTotal > userTotal))
        	System.out.println("Dealer WINS");
        else
        	System.out.println("Player WINS");
    }
    
    public static int getDealerHandValue()
    {
    	return dealerTotal;
    }
}
