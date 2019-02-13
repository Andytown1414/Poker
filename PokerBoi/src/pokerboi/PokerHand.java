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
public class PokerHand {
    
    private ArrayList<Card> cardsInHand;
    private boolean isBust;
    private boolean isBlackjack;
    private boolean isDoubled;
    private boolean isSoft;
    private boolean isSplits;
    private boolean wins;
    private double bet;

    public PokerHand(double betSize) {
        
      this.cardsInHand = new ArrayList<>();
      this.isBust = false;
      this.isBlackjack = false;
      this.isDoubled = false;
      this.isSoft = false;
      this.isSplits = false;
      this.wins = false;
      this.bet = betSize;
      
    }
    
    public int getCardsValue()
    {
        int i;
        int aces = 0;
        int amount = 0;
        for(Card temp : this.cardsInHand)
        {
            if(!temp.getSymbol().equals("A")){
            amount = amount + temp.getValue();
            }else{
                aces++;
            }
        }
        for( i = 0; i < aces; i++)
        {
            amount = amount + 1;
            
        }
        if((aces > 0)&&(amount < 12 ))
            {
                amount = amount + 10;
                
            }
        
        return amount;
    }
    
     public boolean checkForSoft(ArrayList<Card> cards)
    {
        int i;
        int aces = 0;
        int amount = 0;
        boolean softy = true;
        for(Card temp : cards)
        {
            if(!temp.getSymbol().equals("A")){
            amount = amount + temp.getValue();
            }else{
                aces++;
            }
        }
        for( i = 0; i < aces; i++)
        {
            // add aces as worth 1 each.
            amount = amount + 1;
            
        }
        if(aces == 0)
        {
            // if no aces, obviously not a soft hand
            softy = false;
            
        }else if(amount > 11 ){
            // if you have at least 1 ace, total is over 11 using aces as worth 1, then you cant have a soft hand.
            softy = false;
            
        }else{
            // only remaining possibility is to have a soft hand.
            softy = true;
        }
        
       
            return softy;
    }
    
     public void setIsBust() {
        this.isBust = true;
        this.bet = 0.0;
        System.out.println("PLAYER BUST");
        
    }

    public boolean getIsBust() {
        return this.isBust;
    }

    public void setDoubled(boolean doubled) {
        this.isDoubled = doubled;
    }

    public boolean getIsDoubled() {
        return isDoubled;
    }
     
     public boolean getIsBlackjack() {
        return isBlackjack;
    }

    public void setIsSoft(boolean Soft) {
        this.isSoft = Soft;
    }

    public void setWins(boolean wins) {
        this.wins = wins;
    }

    public void setIsDoubled(boolean isDoubled) {
        this.bet = this.bet * 2.0;
        this.isDoubled = isDoubled;
    }

    public void setSplits(boolean Splits) {
        this.isSplits = Splits;
    }

    public boolean getIsSoft() {
        return isSoft;
    }

    public boolean getIsSplits() {
        return isSplits;
    }

    public void setBlackjack(boolean Blackjack) {
        this.isBlackjack = Blackjack;
        if(Blackjack){
        System.out.println("PLAYER BLACKJACK");
        }
        }
    /*
   public double countOfHand()
    {
        double count = 0;
        for(Card c : cardsInHand)
        {
            count = count + Blackjack.countACard(c);
        }
        
        return count;
    }
   */
   public void showCards()
    {
           
        for (Card temp : this.cardsInHand)
        {
            System.out.println(temp.getSymbol());
        }
        
        System.out.println("Max Value: " + this.getCardsValue());
        System.out.println("");
    }
   
    public double handWin()
    {
        //pay player times the multiplier
        if(this.isBlackjack){
            System.out.println("Hand Win - paid out 2.5 x stake" );
            return this.bet * 2.5;
        }else if(this.isDoubled){
            System.out.println("Hand Win - paid out 2 x stake at doubled stake");
              return this.bet * 4.0;
        }else{
            System.out.println("Hand Win - paid out 2 x stake" );
            return this.bet * 2.0;
        }
    }
    
    public void beDealtACard(Card newCard)
    {
        this.cardsInHand.add(newCard);
        if(this.cardsInHand.size() > 1)
        {
        this.setIsSoft(checkForSoft(this.cardsInHand));
        }
    }
    
    
}
