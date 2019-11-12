/*
POJO to be used to display the chip count in game and to write to the score
when user saves or exits
@author Joshua Kleine
@version 1.0
CEN 3031
File: ChipCount.java
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
