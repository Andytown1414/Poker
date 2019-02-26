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
    

// TODO - REALLY SHOULD BE USING THE WORD SCORE INSTEAD OF RANK, AS RANK IMPLIES RANK 1 IS BEST. IM DOING HIGH SCORE
  
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
     
     public static void printHand(ArrayList<Card> hand)
     {
         for (Card cd : hand)
        {
            System.out.print(cd.getSymbol());
        }  
         
         System.out.println("");
     }
    public static long[] evaluateRank5To7(ArrayList<Card> hand)
    {
        long[] rank = {0,0};
        
        switch (hand.size()) {
            case 5:
                rank = evaluateRank5(hand);
                break;
            case 6:
                rank = evaluateRank6(hand);
                break;
            case 7:
                rank = evaluateRank7(hand);
                break;
            default:
                System.out.println("error in evaluaterank5to7");
                rank[0] = -1;
                rank[1] = -1;
                break;
        }
        // ALSO RETURN HAND found at that rank?, SO NEEDS TO RETURN COLLECTION OF 2 THINGS...?
        return rank;
    }
     public static long[] evaluateRank7(ArrayList<Card> hand7)
     {
         // i is the card to skip each time, cause with 6 cards theres only 6 possible hands of 5, 1 left out each time.
            ArrayList<Card> hand6 = new ArrayList();
            long[] rank = {0,0};
        long[] tempRank = {0,0};
            
            
            for(Card c : hand7)
            {
                for(int j = 0; j < 7; j++)
                {
                    if(j != hand7.indexOf(c))
                    {
                        hand6.add(hand7.get(j));
                    }
                }
                tempRank = evaluateRank6(hand6);
                if(tempRank[0] > rank[0])
                rank = tempRank;
                else if ((tempRank[0] == rank[0])&&(tempRank[1] > rank[1]))
                {
                    rank = tempRank;
                }
                hand6.clear();
            }
            return rank;
     }
     public static long[] evaluateRank6(ArrayList<Card> hand6)
     {
         // i is the card to skip each time, cause with 6 cards theres only 6 possible hands of 5, 1 left out each time.
            ArrayList<Card> hand5 = new ArrayList();
            long[] rank = {0,0};
        long[] tempRank = {0,0};
            
            
            for(Card c : hand6)
            {
                for(int j = 0; j < 6; j++)
                {
                    if(j != hand6.indexOf(c))
                    {
                        hand5.add(hand6.get(j));
                    }
                }
                tempRank = evaluateRank5(hand5);
                if(tempRank[0] > rank[0])
                rank = tempRank;
                else if ((tempRank[0] == rank[0])&&(tempRank[1] > rank[1]))
                {
                    rank = tempRank;
                }
                hand5.clear();
            }
            return rank;
     }
     public static long[] evaluateRank5(ArrayList<Card> hand)
     {
         
         
         
         long[] handRank = {0,0};
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
      
         switch (sum)
         {
            case 5:
                //check straight flush
                if(checkStraight(hand)&& checkFlush(hand))
                {
                    // hand must be sorted after calling checkstraight. so if king is second highest
                    // card then must be royal. the reason it checks the king and not ace, is cause
                    // ace will come back in highest spot for a 5 high straight flush e.g 2345A
                    if(hand.get(3).getValue() == 13)
                    {
                        //royal flush
                        // printHand(hand);
                        // System.out.println("ROYAL FLUSH");
                        handRank[0] = 9;
                    }else{
                        //straight flush
                       // printHand(hand);
                       // System.out.println("Straight Flush: " + getStraightFlushRank(hand));
                        handRank[0] = 8;
                        handRank[1] = getStraightFlushRank(hand);
                    }
                }else if (checkFlush(hand))
                {
                    // regular flush
                  //  printHand(hand);
                   // System.out.println("Flush");
                    handRank[0] = 5;
                    handRank[1] = getFlushRank(hand);
                }else if (checkStraight(hand))
                {
                    // regular straight
                    //printHand(hand);
                    //System.out.println("Straight");
                    handRank[0] = 4;
                    handRank[1] = getStraightRank(hand);
                }else{
                 // if matches = 5, and no straight or flush, then must just be high card.   
                 //System.out.println("No Pair");
                 handRank[0] = 0;  
                 handRank[1] = getNoPairRank(hand);
                }
                break;
            case 7:
               // System.out.println("Pair");
                handRank[0] = 1;
                handRank[1] = getPairRank(hand);
                break;
            case 9:
               // System.out.println("Two pair");
                handRank[0] = 2;
                handRank[1] = getTwoPairRank(hand);
                break;
            case 11:
                //printHand(hand);
                //System.out.println("Trips");
                handRank[0] = 3;
                handRank[1] = getTripsRank(hand);
                break;
            case 13:
                //printHand(hand);
                //System.out.println("Full House");
                handRank[0] = 6;
                handRank[1] = getFullHouseRank(hand);
                break;
            case 17:
                //printHand(hand);
                //System.out.println("Quads");
                handRank[0] = 7;
                handRank[1] = getQuadsRank(hand);
                break;
            default:
                // throw some kind of exception here?
                System.out.println("something went wrong with the summation");
            
                
         }
         
         
         
         return handRank;
         
         
     }
    
     
     
     
     public static long getNoPairRank(ArrayList<Card> hand)
     {
        
        //   AKQJT98765432
         
       
         
        char[] charArray = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
                
        
        
        for(Card c : hand)
        {
            charArray[Math.abs(c.getValue() - 14)] = '1';
        }
       
                String binaryString = new String(charArray);
                
        return Long.parseLong(binaryString, 2);
     }
     public static long getPairRank(ArrayList<Card> hand)
     {
         
         
         //get binary binary string of 13 values, so whatever pair you have you make it a 1.
         //then there is another 13 numbers like in getNoPair for the last 3 cards, so its 26 chars long.
         
        
          int temp;
          int pairCard1 = -1;
          int pairCard2 = -1;
          int[] matches = {0,0,0,0,0};
        
         
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                    if(matches[i] == 2)
                    {
                        if(pairCard1 < 0)
                        {
                            pairCard1 = i;
                        }else{
                            pairCard2 = i;
                        }
                    }
                    
                }
            }
            
         }
         
         
        char[] charArrayMSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
        charArrayMSB[Math.abs(hand.get(pairCard1).getValue() - 14)] = '1';
        
        char[] charArrayLSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
                
        
        
        for(Card c : hand)
        {
            if(hand.indexOf(c) != pairCard1 && hand.indexOf(c) != pairCard2)
            {
                charArrayLSB[Math.abs(c.getValue() - 14)] = '1';
            }
            
        }
       
                String binaryStringLSB = new String(charArrayLSB);
                String binaryStringMSB = new String(charArrayMSB);
                String totalBinaryString = binaryStringMSB + binaryStringLSB;
               
                
        return Long.parseLong(totalBinaryString, 2);
       
         
       
     }
     public static long getTwoPairRank(ArrayList<Card> hand)
     {
        
          int temp;
          int pair1Card1 = -1;
          int pair1Card2 = -1;
          int pair2Card1 = -1;
          int pair2Card2 = -1;
         int[] matches = {0,0,0,0,0};
        
         
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                    if(matches[i] == 2)
                    {
                        if(pair1Card1 < 0)
                        {// if card is first card with 2
                            pair1Card1 = i;
                        }
                        else if(hand.get(i).getValue() == hand.get(pair1Card1).getValue())
                            {// if not first 2 card, but has the same value as first 2 card
                                pair1Card2 = i;
                            }
                        else if(pair2Card1 < 0)
                            {
                                pair2Card1 = i;
                            }
                        else
                            {
                                pair2Card2 = i;
                            }
                    }
                    
                }
            }
            
         }
         
         
        char[] charArrayMSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
        charArrayMSB[Math.abs(hand.get(pair1Card1).getValue() - 14)] = '1';
        charArrayMSB[Math.abs(hand.get(pair2Card1).getValue() - 14)] = '1';
        
        char[] charArrayLSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
                
        for(Card c : hand)
        {
            if(hand.indexOf(c) != pair1Card1 && hand.indexOf(c) != pair1Card2 && hand.indexOf(c) != pair2Card1 && hand.indexOf(c) != pair2Card2)
            {
                charArrayLSB[Math.abs(c.getValue() - 14)] = '1';
            }
               
        }
       
                String binaryStringLSB = new String(charArrayLSB);
                String binaryStringMSB = new String(charArrayMSB);
                String totalBinaryString = binaryStringMSB + binaryStringLSB;
                
        return Long.parseLong(totalBinaryString, 2);
     }
     public static long getTripsRank(ArrayList<Card> hand)
     {
        
          int temp;
          int tripCard1 = -1;
          int tripCard2 = -1;
          int tripCard3 = -1;
         int[] matches = {0,0,0,0,0};
        
         
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                    if(matches[i] == 3)
                    {
                        if(tripCard1 < 0)
                        {
                            tripCard1 = i;
                        }else if(tripCard2 < 0){
                            tripCard2 = i;
                        }else
                        {
                            tripCard3 = i;
                        }
                    }
                    
                }
            }
            
         }
         
         
        char[] charArrayMSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
        charArrayMSB[Math.abs(hand.get(tripCard1).getValue() - 14)] = '1';
        
        char[] charArrayLSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
                
        
        
        for(Card c : hand)
        {
            if(hand.indexOf(c) != tripCard1 && hand.indexOf(c) != tripCard2 && hand.indexOf(c) != tripCard3)
            {
                charArrayLSB[Math.abs(c.getValue() - 14)] = '1';
            }
            
        }
       
                String binaryStringLSB = new String(charArrayLSB);
                String binaryStringMSB = new String(charArrayMSB);
                String totalBinaryString = binaryStringMSB + binaryStringLSB;
               
        return Long.parseLong(totalBinaryString, 2);
     }
     public static long getStraightRank(ArrayList<Card> hand)
     {
        // check the hand (which is already sorted) for the last card and return based on that value.
         // so king high is score of 8, and 5 high is score of 0
         switch (hand.get(3).getValue())
         {
             case 13:
                 return 9;
             case 12:
                 return 8;
             case 11:
                 return 7;
             case 10:
                 return 6;
             case 9:
                 return 5;
             case 8:
                 return 4;
             case 7:
                 return 3;
             case 6:
                 return 2;
             case 5:
                 return 1;
             case 4:
                 return 0;
             default:
                 return -1;
             
         }
     }
     public static long getFlushRank(ArrayList<Card> hand)
     {
        // this works by checking for highest card in hand. this works because in texas holdem there can never be flush vs flush of a different suit.
         // the only showdown with flushes is if players have the same suit flush, in which case the single highest card is all the matters.
         switch (hand.get(4).getValue())
         {
             case 14:
                 return 9;
             case 13:
                 return 8;
             case 12:
                 return 7;
             case 11:
                 return 6;
             case 10:
                 return 5;
             case 9:
                 return 4;
             case 8:
                 return 3;
             case 7:
                 return 2;
             case 6:
                 return 1;
             case 5:
                 return 0;
             default:
                 return -1;
             
         }
     
     }
        
     public static long getFullHouseRank(ArrayList<Card> hand)
     {
          int temp;
          int tripCard1 = -1;
          int tripCard2 = -1;
          int tripCard3 = -1;
          int pairCard1 = -1;
         int[] matches = {0,0,0,0,0};
        
         
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                    if(matches[i] == 3)
                    {
                        if(tripCard1 < 0)
                        {
                            tripCard1 = i;
                        }else if(tripCard2 < 0){
                            tripCard2 = i;
                        }else
                        {
                            tripCard3 = i;
                        }
                    }
                    
                }
            }
            if(matches[i] == 2 && pairCard1 < 0)
            {
                pairCard1 = i;
            }
            
         }
         
         
        char[] charArrayMSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
        charArrayMSB[Math.abs(hand.get(tripCard1).getValue() - 14)] = '1';
        
        char[] charArrayLSB = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
                
        charArrayLSB[Math.abs(hand.get(pairCard1).getValue() - 14)] = '1';
        
        
       
                String binaryStringLSB = new String(charArrayLSB);
                String binaryStringMSB = new String(charArrayMSB);
                String totalBinaryString = binaryStringMSB + binaryStringLSB;
               
        return Long.parseLong(totalBinaryString, 2);
     }
     public static long getQuadsRank(ArrayList<Card> hand)
     {
        
          int temp;
          int quadCard = -1;
          int[] matches = {0,0,0,0,0};
        
         outerloop:
         for(int i = 0; i < 5;i++)
         {
            temp = hand.get(i).getValue();
            
            for(int j = 0; j<5;j++)
            {
                if(hand.get(j).getValue() == temp)
                {
                    matches[i]++;
                    if(matches[i] == 4)
                    {
                        quadCard = i;
                        break outerloop;
                    }
                    
                }
            }
            
         }
         
         
        char[] charArray = {'0','0','0','0','0','0','0','0','0','0','0','0','0'};
        charArray[Math.abs(hand.get(quadCard).getValue() - 14)] = '1';
        
       
                String binaryString = new String(charArray);
                
               
        return Long.parseLong(binaryString, 2);
     }
     public static long getStraightFlushRank(ArrayList<Card> hand)
     {
         // this method should never be called with a royal flush, so if fifth card is an ace then it must be a 5 high straight flush
         // 
         switch (hand.get(4).getValue())
         {
             case 14:
                 return 0;
             case 13:
                 return 8;
             case 12:
                 return 7;
             case 11:
                 return 6;
             case 10:
                 return 5;
             case 9:
                 return 4;
             case 8:
                 return 3;
             case 7:
                 return 2;
             case 6:
                 return 1;
             default:
                 return -1;
             
         }
     }
     
     
}