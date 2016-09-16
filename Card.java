/**
 * @(#)Card.java
 *
 *
 * @author 
 * @version 1.00 2013/6/1
 */


public class Card {

	public int value;
	public String suit;
	
    public Card(int num, String s)
    {
    	value = num;
    	suit = s;
    }
    
    public String toString()
    {
    	if (value <= 10)
    		return value + " of " + suit;
    	
    	else
    	{
    		if (value == 11)
    			return "Jack of " + suit;
    		if (value == 12)
    			return "Queen of " + suit;
    		if (value == 13)
    			return "King of " + suit;
    		if (value == 14)
    			return "Ace of " + suit;
    		else
    			return "2 of Diamonds";
    	}
    }
    
    
}