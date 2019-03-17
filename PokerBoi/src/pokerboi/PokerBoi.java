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
   ArrayList<Card> commonCards;
   private ArrayList<Player> players;
   private Player player1;
   private Player player2;
   
    public PokerBoi()
    {
       // this.pot = 0;
        //this.blindsAmount = 5;
       
        this.pokerDeck = new Deck();
        this.commonCards= new ArrayList<>();
        this.players = new ArrayList();
        this.player1 = new Player();
        this.players.add(player1);
        this.player2 = new Player();
        this.players.add(player2);
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
        
     //   game.playRound();v
        PokerBoi theGame = new PokerBoi();
        
       theGame.test1();
    }
     private void playRound()
    {
        //player 0 pay small blinds
        // player 1 pay big blinds
        // deal 2 cards to each players
        // deal 3 cards to table
    }
    private void test1()
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
        
        long roundsToPlay = 5;
        
       
        
        long[] rankP1 = {0,0};
        long[] rankP2 = {0,0};
        for(int g = 0;g < roundsToPlay;g++)
        {
            // fresh deck for each round. does not set to null or anything, just clears its cards out and fills again. doesnt need to be set to null as it has no other properties that matter from game to game.
            this.pokerDeck.reFreshDeck();
            this.commonCards.clear();
            
            
            for(Player p : players)
            {
                p.ditchCards();
                p.getDealtHoleCards(this.pokerDeck.getCard(),this.pokerDeck.getCard());
                
            }
                for(int i = 0;i< 5; i++)
                {
                    this.commonCards.add(this.pokerDeck.getCard());
                }
                System.out.println("-------------------------------------");
                System.out.print("common cards: ");
                for(Card c : commonCards)
                {
                    System.out.print(c.getSymbol());
                }
                System.out.println("");
               
              // System.out.println("size of commoncards before rankp1: " + commonCards.size());
                rankP1 = Evaluator.evaluateRank5To7Opt(commonCards,player1.getHoleCards());
              //  System.out.println("size of commoncards after rankp1: " + commonCards.size());
                
                rankP2 = Evaluator.evaluateRank5To7Opt(commonCards,player2.getHoleCards());
               // System.out.println("Rank: " + rank[0] + " , " + rank[1]);
               // System.out.println("");
                player1.printHoleCards();
                System.out.println("player 1 rank : " + rankP1[0]+", " + rankP1[1]);
                player2.printHoleCards();
                 System.out.println("player 2 rank : " + rankP2[0]+", " + rankP2[1]);
                
                /*
                // THE REST OF THIS METHOD IS JUST FOR STATS TO PRINT OUT AT THE END
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
               */
        }
        /*
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
     */
    }
    
   
    
    
       
}
    
    

