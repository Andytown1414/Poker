/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokerboi;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class PokerBoi {

   private double pot;
   private double blindsAmount;
   private Deck pokerDeck;
   private ArrayList<Player> players;
   
   
    public PokerBoi()
    {
       // this.pot = 0;
        //this.blindsAmount = 5;
        //this.players = new ArrayList<>();
        this.pokerDeck = new Deck();
    }
   
    
    
    public static void main(String[] args) {
        
        // TODO code application logic here
      //  PokerBoi game = new PokerBoi();
       // game.pokerDeck = new Deck();
        //get number of players in round
      //  game.players.add(new Player());
    //    game.players.add(new Player());
       // game.players.add(new Player());
       // game.players.add(new Player());
        
     //   game.playRound();


       test1();
    }
     private void playRound()
    {
        //player 0 pay small blinds
        // player 1 pay big blinds
        // deal 2 cards to each players
        // deal 3 cards to table
    }
    private static void test1()
    {
        double noPairCount = 0;
        double pairCount = 0;
        double twoPairCount = 0;
        double tripsCount = 0;
        double straightCount = 0;
        double flushCount = 0;
        double fullHouseCount = 0;
        double quadsCount = 0;
        double straightFlushCount = 0;
        double royalFlushCount = 0;
        double roundsPlayed = 0;
        
        long roundsToPlay = 1000000;
        
       
        
        long[] rank = {0,0};
       
        for(int g = 0;g < roundsToPlay;g++)
        {
            
            
                PokerBoi theGame = new PokerBoi();
                ArrayList<Card> aHand = new ArrayList<>();
            
                for(int i = 0;i< 7; i++)
                {
                    aHand.add(theGame.pokerDeck.getCard());
                }
               
                rank = Evaluator.evaluateRank5To7(aHand);
               // System.out.println("Rank: " + rank[0] + " , " + rank[1]);
               // System.out.println("");
                
                
                switch ((int)rank[0])
         {
             case 0:
                 noPairCount++;
             break;  
              case 1:
                 pairCount++;
             break;
              case 2:
                 twoPairCount++;
             break;
              case 3:
                 tripsCount++;
             break;
              case 4:
                 straightCount++;
             break;
              case 5:
                 flushCount++;
             break;
              case 6:
                 fullHouseCount++;
             break;
             case 7:
                 quadsCount++;
             break;
             case 8:
                 straightFlushCount++;
             break;
             case 9:
                 royalFlushCount++;
             break;
         }
                
                
                roundsPlayed++;        
        }
        
        System.out.println("Rounds Played = " + roundsPlayed);
        System.out.println("No Pairs = " + noPairCount + ". Frequency = " + (noPairCount * 100)/roundsPlayed + "%");
        System.out.println("Pairs = " + pairCount + ". Frequency = " + (pairCount * 100)/roundsPlayed + "%");
        System.out.println("Two Pair = " + twoPairCount + ". Frequency = " + (twoPairCount * 100)/roundsPlayed + "%");
        System.out.println("Trips = " + tripsCount + ". Frequency = " + (tripsCount * 100)/roundsPlayed + "%");
        System.out.println("Straights = " + straightCount + ". Frequency = " + (straightCount * 100)/roundsPlayed + "%");
        System.out.println("Flushes = " + flushCount + ". Frequency = " + (flushCount * 100)/roundsPlayed + "%");
        System.out.println("FullHouse = " + fullHouseCount + ". Frequency = " + (fullHouseCount * 100)/roundsPlayed + "%");
        System.out.println("Quads = " + quadsCount + ". Frequency = " + (quadsCount * 100)/roundsPlayed + "%");
        System.out.println("Straight Flushes = " + straightFlushCount+ ". Frequency = " + (straightFlushCount * 100)/roundsPlayed + "%");
        System.out.println("Royal Flushes = " + royalFlushCount+ ". Frequency = " + (royalFlushCount * 100)/roundsPlayed + "%");
    }
    
   
    
    
       
}
    
    

