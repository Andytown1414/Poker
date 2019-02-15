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
        this.pot = 0;
        this.blindsAmount = 5;
        this.players = new ArrayList<>();
    }
   
    
    
    public static void main(String[] args) {
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
    
    public void assessHand(){
        /*
//basic for assessing hand. i dunno if you should then assign a score to it?
// HMM IVE STARTED SCORE SYSTEM BELOW BUT IM NOT SURE ITS HTE BEST WAY
	check for RF
		Score : 1
	check for SF
	// based on highest card in SF
		K - 2
		Q - 3
		J - 4
		10 - 5
		9 - 6
		8,7,6,5 -> 7,8,9,10
		
	check quad
		AAAA - 11
		KKKK - 12
		QQQQ - 13
		...
		2222 - 23
	check full house
		// MAYBE SAY IF TRIPS AND A PAIR (MAKE SUR ETHE PAIR ISNT PART OF THE TRIPS) THEN ASSES THE ..TRIPS? I DUNNO.
		// btw to score a full house its whoever has the highest trips. if trips are equal due to communcal cards, then its highest pair.
	check flush
	check straight
	ALL CARDS FROM HERE UP HAVE NO KICKER. QUADS DOES BUT ITS IRRELEVANT.


	check trips
	check 2 pair
	check pair
	*/
    }
}
