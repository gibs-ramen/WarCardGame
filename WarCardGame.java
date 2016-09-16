/**
 * @(#)WarCardGame.java
 *
 *
 * @author 
 * @version 1.00 2013/6/1
 */

import java.util.*;

public class WarCardGame {

	public static ArrayList<Card> deck;
	public static ArrayList<Card> player1Deck;
	public static ArrayList<Card> player2Deck;
	public static boolean won;
	
    public static int main()
    {
    	won = false;
    	deck = new ArrayList<Card>();
    	   	
    	for (int i = 2; i <= 14; i++) //construct ordered deck
    	{
    		deck.add(new Card(i, "Diamonds"));
			deck.add(new Card(i, "Clubs"));
			deck.add(new Card(i, "Hearts"));
			deck.add(new Card(i, "Spades"));
    	}
    	
    	//assign each player a randomized deck
    	player1Deck = randomizeDeck(); 
    	player2Deck = randomizeDeck();
    	int turns = 0;
    	
    	while (player1Deck.size() > 0 && player2Deck.size() > 0 && !won) //while each player has cards in the deck
    	{   
    		turns++;
    			
    		Card p1Card = player1Deck.get(0);
    		Card p2Card = player2Deck.get(0);
    			
    		if (p1Card.value > p2Card.value) //player1's card is higher
    		{
    			//put both cards at the bottom of player2's deck
    			player1Deck.add(p2Card);
    			player1Deck.add(p1Card);
    			player1Deck.remove(0);
    			player2Deck.remove(0);			
    		}
    		
    		else if (p2Card.value > p1Card.value) //player2's card is higher
    		{
    			//put both cards at the bottom of player1's deck
    			player2Deck.add(p1Card);
    			player2Deck.add(p2Card);
    			player1Deck.remove(0);
    			player2Deck.remove(0);
    			
    		}
    		
    		else //WAR!
    			war(5);    			
    			
    	}
    	
    	return turns;
    	
    }
    
    //Returns a randomized deck for each player
    
    public static ArrayList<Card> randomizeDeck()
    {
    	ArrayList<Card> randDeck = new ArrayList<Card>();
    	ArrayList<Card> tempDeck = new ArrayList<Card>();;
    	
    	for (int i = 0; i < 52; i++)
    		tempDeck.add(deck.get(i));
    	
    	while(!tempDeck.isEmpty()) //pick random card to move to front of randomized deck
    	{	
    		int randomPosition = (int) (Math.random() * (tempDeck.size()));
    		randDeck.add(tempDeck.get(randomPosition));
    		tempDeck.remove(randomPosition);
    	}
    	
    	return randDeck;
    	
    }
    
    /*War is performed by each player flipping three additional cards face down
     *and the fourth card face up.  The player with the higher of the face up
     *cards receives all cards played in that turn, a total of 10 cards.  If 
     *the two face up cards have the same value then another war is performed.
     */
    
    public static void war(int endingCardIndex) //endingCardIndex for double/triple wars
    {	
    	//if a player does not have enough cards to perform a war, they lose
    	
		if (player1Deck.size() < endingCardIndex || player2Deck.size() < endingCardIndex)
		{
			won = true;
			return;
		}
		
		//if player1's card has a greater value than player2's card, add all cards to player1's deck
		
		else if (player1Deck.get(endingCardIndex-1).value > player2Deck.get(endingCardIndex-1).value)
		{			
			for (int i = 0; i < endingCardIndex; i++)
				player1Deck.add(player2Deck.get(i));
			
			for (int i = 0; i < endingCardIndex; i++)
				player1Deck.add(player1Deck.get(0));
			
			for (int i = 0; i < endingCardIndex; i++)
			{
				player2Deck.remove(0);	
				player1Deck.remove(0);							
			}
		}
		
		//if player2's card has a greater value than player1's card, add all cards to player2's deck
		
		else if (player2Deck.get(endingCardIndex-1).value > player1Deck.get(endingCardIndex-1).value)
		{	
			for (int i = 0; i < endingCardIndex; i++)
				player2Deck.add(player1Deck.get(i));
			
			for (int i = 0; i < endingCardIndex; i++)
				player2Deck.add(player2Deck.get(0));
			
			for (int i = 0; i < endingCardIndex; i++)
			{
				player1Deck.remove(0);
				player2Deck.remove(0);
			}
		}
		
		else //double/triple wars
			war(endingCardIndex+5);
			
    }
}