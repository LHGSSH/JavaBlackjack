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
    Deck hand;
    //TODO: handle if the shoe is empty before dealing by creating a new shoe
    //New game manager is created every time the entire game restarts, not between hands
    //Landing must allow user to log in (can just let them put in username and password
    // and make new user if not found in file.
    public GameManager(){
        s1 = new Shoe();
        User u1 = new User();
        hand = new Deck(0);
        chips = new ChipCount(startingChips);
    }

    //Returns the next card, moves to next deck otherwise
    
    public void hit(){
        if (s1.isShoeEmpty()){
            s1 = new Shoe();
        }
        hand.deckOfCards.add(s1.deal());
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
        //Deal twice to hand
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
