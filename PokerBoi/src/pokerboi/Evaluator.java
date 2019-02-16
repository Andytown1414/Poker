/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerboi;

import java.util.ArrayList;

/**
 *
 * @author andre
 */

// Should always evaluate 5 cards only. cause thats the only showdown hand size. if you have 7 cards total, then just call evaluate with all possible combinations of 5, which should be 15 for 6 cards(turn) and 21 times for 7 cards(river)
// for now i just want it to itetify the type of hand, a tie can be dealt with later, for now i just wanna know what the hand is on a very basic level.
public class Evaluator {
    


  
    public static ArrayList<Card> sortHand(ArrayList<Card> hand)
    {
        //some kind of sort?
        int n = hand.size() - 1; 
        //System.out.println(n);
        Card temp;  
        
        for(int i=0; i < n; i++)
        {  
            for(int j=1; j < (n-i+1); j++)
            {  
                if(hand.get(j-1).getValue() > hand.get(j).getValue())
                {  
                       //swap elements  
                       temp = hand.get(j-1);  
                       hand.set(j-1,hand.get(j));
                       hand.set(j,temp);  
                                 
                }          
            }  
        
        
       
        }
         return hand;
    }

    public static boolean checkStraightOfSortedHand(ArrayList<Card> hand)
    {
        // must be size of 5!!
        // must be sorted
        boolean straight = true;
        
      for(int i = 0; i < hand.size()- 1 ;i++)
      {
          if(hand.get(i).getValue() - hand.get(i+1).getValue() != -1)
          {
              straight = false;
          }    
      }
      
      return straight;
      
    }
    
    public static boolean checkStraight(ArrayList<Card> hand)
    {
        return checkStraightOfSortedHand(sortHand(hand));
    }
}