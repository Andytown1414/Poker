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
   private double blinds;
   private Deck pokerDeck;
   private ArrayList<Player> players;
   
   
    public PokerBoi()
    {
        this.pot = 0;
        this.blinds = 5;
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
    
    public String calcHand(ArrayList<Card> cards) throws NumberFormatException
    {
        String theHand = "snuh";
        if (cards.size() != 5){
                System.out.println("error, must be 5 cards passed to calcHand");
                throw new NumberFormatException();
                   
        }
        return theHand;
    }
    
}
