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
public class Player {
    
    private ArrayList<Card> holeCards;
    private ArrayList<Card> best5Cards;
    private Long[] rank;
    private double CHIPS = 10000;
    private boolean inRound = false;
    public Player()
    {
        this.holeCards = new ArrayList();
    }
    public void upDateBestHand(ArrayList<Card> commons)
    {
        ArrayList<Card> total;
        //total =  combine holecards with commons and call evaluate with al combinations.
       // Evaluator.evaluateRank5(total)
         //       or
     //   Evaluator.evaluateRank6(total)
             //   or Evaluator.evaluateRank7(total)
    }
    public String getAction()
    {
        return "hi";
    }
    
    public void getDealtHoleCards(Card holeCard1,Card holeCard2)
    {
        this.holeCards.add(holeCard1);
        this.holeCards.add(holeCard2);
        // maybe here call getRank for 2 cards?
    }

    public ArrayList<Card> getHoleCards() {
        return holeCards;
    }
    
    public void ditchCards()
    {
        this.holeCards.clear();
        // should also reset rank maybe?
    }
    public void printHoleCards()
    {
        System.out.print(this.holeCards.get(0).getSymbol());
        System.out.println(this.holeCards.get(1).getSymbol());
    }
}
