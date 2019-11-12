/*
This file stores User data to a file and provides methods to encrypt the password,
as well as to validate login and change password "securely"
@author Joshua Kleine
@version 1.0
CEN 3031
File: User.java
*/
public class ChipCount {
    private int numChips;

    public ChipCount(){
        this.numChips = 0;
    }

    public ChipCount(int numChips){
        this.numChips = numChips;
    }

    public void setNumChips(int numChips) {
        this.numChips = numChips;
    }

    public int getNumChips() {
        return numChips;
    }
}
