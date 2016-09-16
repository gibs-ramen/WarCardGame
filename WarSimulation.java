/**
 * @(#)WarSimulation.java
 *
 *
 * @author 
 * @version 1.00 2013/6/1
 */

import java.util.*;

public class WarSimulation {

    public static void main(String[]args)
    {
    	while (true)
    	{	    	
	    	Scanner kb = new Scanner(System.in);
		    System.out.print("Number of Trials: ");   	
	    	int trials = kb.nextInt();
	    	
	    	if (trials == 0)
	    	{
	    		System.out.print("ERROR: CANNOT PERFORM ZERO TRIALS\n");
	    		trials = 1;
	    	}
	    			
	    	int sum = 0;
	    	int turns = 0;
	    	int maxTurns = 0;
	    	int minTurns = 1000;
	    	
	    	for (int i = 0; i < trials; i++)
	    	{
	    		turns = WarCardGame.main();
	    		sum+=turns;
	    		
	    		if (turns > maxTurns)
	    			maxTurns = turns;
	    		if (turns < minTurns)
	    			minTurns = turns;
	    			
	    		System.out.println("Simulating Game " + (i+1) + " out of " + trials + "...");
	    	}
	    	
	    	System.out.println("\nAverage Number of Turns: " + 1.0 * sum/trials);
	    	System.out.println("Maximum Number of Turns: " + 1.0 * maxTurns);
	    	System.out.println("Minimum Number of Turns: " + 1.0 * minTurns + "\n");
    	}   	 
   
	}
}