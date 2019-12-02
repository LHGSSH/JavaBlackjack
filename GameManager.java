/*
This class provides the logic for the Blackjack game.
@version 1.0
CEN 3031
File: GameManager.java
*/
public class GameManager {

    Shoe s1;
    ChipCount chips;
    int dealerTotal = 0;
    int userTotal = 0;
    //The score a new User gets
    int startingChips = 100;
    Deck userHand;
    Deck dealerHand;
    //TODO: handle if the shoe is empty before dealing by creating a new shoe
    //New game manager is created every time the entire game restarts, not between hands
    //Landing must allow user to log in (can just let them put in username and password
    // and make new user if not found in file.
    public GameManager(String username, String password){
        s1 = new Shoe();
        User u1 = new User();
        userHand = new Deck(0);
        dealerHand = new Deck(0);
        if(u1.loginCheck(username,password))
            chips = new ChipCount(u1.retrieveScore(username, password));
        else {
            //Making a new user account and giving default chip count
            u1 = new User(username, password);
            chips = new ChipCount(startingChips);
        }
    }

    //Returns the next card and adds its value to the user's total.
    // Moves to next deck, otherwise.
    
    public Card hit(){
        if (s1.isShoeEmpty()){
            s1 = new Shoe();
        }
        userHand.deckOfCards.add(s1.deal());
        //TODO: Add total of dealt card to userTotal
        //TODO: Add logic for ace card.
        //If the user gets an ace and if having it as an 11 won't push them over 21,
        //then set the ace's value as 11. Else, set it as 1.
        return userHand.dealCard();
    }
    
    public boolean bet(int betAmount){
        //TODO needs logic, this is just so it will compile
        return true;
    }
    
    public void stay(){
        dealerMove(dealerTotal);
    }

    public void endGame(ChipCount chips){
        //save the chip count to the user score
    }

    public void startGame(){
        //Deal twice to hand
        dealerMove(dealerTotal);
        dealerMove(dealerTotal);
        hit();
        hit();
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
    public void dealerMove(int currentScore) {
        Card dealtCard;
        if (currentScore < 17) {
            //Draw card
            dealtCard = s1.deal();
            dealerTotal += dealtCard.getValue();
            //TODO: Add logic for ace card.
            dealerHand.deckOfCards.add(dealtCard);
        }
    }
}
