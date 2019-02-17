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
        //bubblesort
        // will always make an ace the highest, so if checking for straight after this, the ace low straight needs to be considered
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
         boolean straight;
        // must be size of 5!!
        // must be sorted
        
        // first account for ace low (5 high) straight
        if(hand.get(0).getValue() == 2 && hand.get(1).getValue() == 3 && hand.get(2).getValue() == 4 && hand.get(3).getValue() == 5 && hand.get(4).getValue() == 14)
        {
            straight = true;
        }
        else{
            straight = true;
            for(int i = 0; i < hand.size()- 1 ;i++)
            {
                if(hand.get(i).getValue() - hand.get(i+1).getValue() != -1)
                {
                    straight = false;
                }    
            }
        }
      return straight;
      
    }
    
    public static boolean checkStraight(ArrayList<Card> hand)
    {
        return checkStraightOfSortedHand(sortHand(hand));
    }
    
     public static boolean checkFlush(ArrayList<Card> hand)
    {
        boolean flush = true;
        
        for(int i = 0; i < hand.size()- 1 ;i++)
        {
             if(!hand.get(i).getSuit().equals(hand.get(i+1).getSuit()))
          {
              flush = false;
          }  
        }
    
        return flush;
    }
     
     public static void countMatches(ArrayList<Card> hand)
     {
         
        
         int temp;
         
         int[] matches = {0,0,0,0,0};
        
         
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                }
            }
            
         }
         
         
         int sum = 0;
         
         for(int i = 0; i < 5;i++)
         {
             sum += matches[i];
         }
         
         for(Card c : hand)
         {
             System.out.println(c.getSymbol());
         }
         
         System.out.println("sum is: " + sum);
         switch (sum)
         {
            case 5:
                System.out.println("no pair");
                // here is where you would check straight n flush i guess?
                break;
            case 7:
                System.out.println("pair");
                break;
            case 9:
                System.out.println("two pair");
                break;
            case 11:
                System.out.println("trips");
                break;
            case 13:
                System.out.println("full house");
                break;
            case 17:
                System.out.println("quads");
                break;
            default:
                System.out.println("something went wrong with the summation");
            
              
                 
         }
         
         
         
         
         
            //    System.out.println(matches);
     }
}