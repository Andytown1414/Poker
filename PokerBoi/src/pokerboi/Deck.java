/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokerboi;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class Deck {
     private ArrayList<Card> cards;
     private Random randomGenerator;
     private int numberOfDecks;
        
     
    public Deck(){
       
        cards = new ArrayList<>();
        randomGenerator = new Random();
       
       
        addSuit("Hearts");
        addSuit("Diamonds");
        addSuit("Spades");
        addSuit("Clubs");
        
    }
    
    private void addSuit(String suit)
    {
       cards.add(new Card(suit, "2"));
       cards.add(new Card(suit, "3"));
       cards.add(new Card(suit, "4"));
       cards.add(new Card(suit, "5"));
       cards.add(new Card(suit, "6"));
       cards.add(new Card(suit, "7"));
       cards.add(new Card(suit, "8"));
       cards.add(new Card(suit, "9"));
       cards.add(new Card(suit, "T"));
       cards.add(new Card(suit, "J"));
       cards.add(new Card(suit, "Q"));
       cards.add(new Card(suit, "K"));
       cards.add(new Card(suit, "A"));
     
       
       
    }
    
    public Card getCard()
    {
        int index = randomGenerator.nextInt(this.cards.size());
        //System.out.println(index);
        Card drawnCard = this.cards.get(index);
        this.cards.remove(index);
        //System.out.println("Card Removed From Deck, Cards Remaining:" + this.cards.size());
        return drawnCard;
    }
    
    public int cardsRemaining()
    {
        return this.cards.size();
    }
    
    public double decksRemaining()
    {
        return cardsRemaining()/52.0;
    }
}
