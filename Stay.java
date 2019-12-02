/*
 * Class to implement 'stay' functionality when 'Stay' button is pressed
 */
public class Stay {

	public static void main(String[] args) 
	{
		System.out.println("Player stays!");
		
		int dealerTotal = GameManager.getDealerHandValue();
		
		GameManager.dealerMove(dealerTotal);

	}

}
