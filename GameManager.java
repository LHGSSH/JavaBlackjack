/*
This class provides the logic for the Blackjack game.
@version 1.0
CEN 3031
File: GameManager.java
*/
public class GameManager {

    Shoe s1;
    ChipCount chips;
    int dealerTotal, userTotal;
    //The score a new User gets
    int startingChips = 100;
    Deck userHand;
    Deck dealerHand;
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

    //Returns the next card, moves to next deck otherwise
    
    public void hit(){
        if (s1.isShoeEmpty()){
            s1 = new Shoe();
        }
        userHand.deckOfCards.add(s1.deal());
    }
    
    public boolean bet(int betAmount){
        //TODO needs logic, this is just so it will compile
        return true;
    }
    
    public void stay(){
        //TODO needs logic, this is just so it will compile
    }

    public void endGame(ChipCount chips){
        //save the chip count to the user score
    }

    public void startGame(){
        userHand.deckOfCards.add(s1.deal());
        userTotal = userHand.deckOfCards.get(0).getValue();
        System.out.println("First User Card Value: " + userTotal);

        userHand.deckOfCards.add(s1.deal());
        userTotal += userHand.deckOfCards.get(1).getValue();
        System.out.println("Second User Card Value: " + userTotal);
        //test

        dealerHand.deckOfCards.add(s1.deal());
        dealerTotal = dealerHand.deckOfCards.get(0).getValue();
        System.out.println("First Dealer Card Value: " + dealerTotal);

        dealerHand.deckOfCards.add(s1.deal());
        dealerTotal += dealerHand.deckOfCards.get(1).getValue();
        System.out.println("Second Dealer Card Value: " + dealerTotal);
    }
    public void updateHand(){
        //may interact with landing
    }
    public boolean isBust(int total){
        if (total > 21){
            return true;
        }
        return false;
    }
    public boolean isRoundOver(){

        return false;
    }
    public void dealerMove(int currentScore){
        if (currentScore >= 17)
            //do not draw card\
            ;
        else //draw card
        ;
    }
}
