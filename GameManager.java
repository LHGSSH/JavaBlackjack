/*
This file stores User data to a file and provides methods to encrypt the password,
as well as to validate login and change password "securely"
@version 1.0
CEN 3031
File: User.java
*/
public class GameManager {

    Shoe s1;
    //TODO: handle if the shoe is empty before dealing by creating a new shoe
    public GameManager(User u1){
        s1 = new Shoe();
    }

    //Returns the next card, moves to next deck otherwise
    public Card hit(){
       //TODO needs logic, this is just so it will compile
        return s1.deal();
    }
    public boolean bet(int betAmount){
        //TODO needs logic, this is just so it will compile
        return true;
    }

    public void stay(){
        //TODO needs logic, this is just so it will compile
    }

}
