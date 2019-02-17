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
        /*
        // TODO code application logic here
        PokerBoi game = new PokerBoi();
        game.pokerDeck = new Deck();
        //get number of players in round
        game.players.add(new Player());
        game.players.add(new Player());
        game.players.add(new Player());
        game.players.add(new Player());
        // get new deck
        game.playRound();

*/
        //TEST1-------------------------------------------------------------------------
        /*
        double flushCount = 0;
        double straightCount = 0;
        double straightFlushCount = 0;
        double royalFlushCount = 0;
        double roundsPlayed = 0;
        
        boolean flush = false;
        boolean straight = false;
        boolean straightFlush = false;
        
       
        for(int g = 0;g < 1000000;g++)
        {
            flush = false;
            straight = false;
            
        
                PokerBoi theGame = new PokerBoi();
                ArrayList<Card> aHand = new ArrayList<>();
            
                for(int i = 0;i< 5; i++)
                {
                    aHand.add(theGame.pokerDeck.getCard());
                }
                //print out each card
               if(Evaluator.checkStraight(aHand))
               {
                 //  System.out.println("straight!!!!");
                   straight = true;
               }else{
                  //System.out.println("no straight");
               }

                if(Evaluator.checkFlush(aHand))
               {
                   //System.out.println("flush!!!!");
                   flush = true;
               }else{
                   //System.out.println("no flush");
               }
                // counting so if you get a straightflush, that is just that, it doesnt add to straightcount of flushcount. only adds to straightflushcount
                if(flush && straight)
                {
                    //first check if its royal
                    if(aHand.get(4).getValue() == 14 && aHand.get(3).getValue() == 13)
                    {
                        royalFlushCount++;
                    }else{
                        straightFlushCount++;
                    }
                }else if(straight)
                        {
                           straightCount++; 
                        }
                else if(flush)
                        {
                           flushCount++; 
                        }
                roundsPlayed++;        
        }
        
        System.out.println("Rounds Played = " + roundsPlayed);
        System.out.println("Straights = " + straightCount + ". Frequency = " + (straightCount * 100)/roundsPlayed + "%");
        System.out.println("Flushes = " + flushCount+ ". Frequency = " + (flushCount * 100)/roundsPlayed + "%");
        System.out.println("Straight Flushes = " + straightFlushCount+ ". Frequency = " + (straightFlushCount * 100)/roundsPlayed + "%");
        System.out.println("Royal Flushes = " + royalFlushCount+ ". Frequency = " + (royalFlushCount * 100)/roundsPlayed + "%");
        */
         //end test1------------------------------------------------------------------------------
         //TEST2----------------------------------------------------------------------------------
         
         
                PokerBoi theGame = new PokerBoi();
                ArrayList<Card> aHand = new ArrayList<>();
               
                for(int i = 0;i< 5; i++)
                {
                    aHand.add(theGame.pokerDeck.getCard());
                }
                
                Evaluator.countMatches(aHand);
         
         
         
         //endtest2-------------------------------------------------------------------------------
    }
    
    private void playRound()
    {
        //player 0 pay small blinds
        // player 1 pay big blinds
        // deal 2 cards to each players
        // deal 3 cards to table
    }
    
    public void calcHand(ArrayList<Card> cards) throws NumberFormatException
    {
      // check that there is between 2 and 7 cards first
       if ((cards.size() >= 2)&&(cards.size() <= 7)) 
               {
                   // check 
                  if(cards.size() == 2)
                  {
                     //check pairs
                  }else if(cards.size()== 3)
                  {
                      //check trips
                      //check pairs
                  }else if(cards.size()== 4)
                  {
                      //check quads
                      //check trips
                      //check twopair
                      //check pairs
                      
                     
                     
                  }else{
                      // these ones it gets tricky, cause you dont wanna say check for straight, and then not check for flush, or vice versa
                      // i guess solution is that these check if thats ALL you have
                      // 
                      
                      //check RF
                      //check SF house check if thats ALL you have, although SF needs rank anyway so RF really doesnt need to exist
                      //check quads
                      //check full house check if thats ALL you have, cause you can have this but also quads with 7 cards
                      //check flush
                      //check straight
                      //check trips
                      //check twopair
                      //check pairs
                  }
                   
                   
                   
                   
                   
                   
               }else{
           System.out.println("throw some exception here? needs to be 2 - 7 cards");
       }
       }
       
}
    
    

