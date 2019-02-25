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
    public Player()
    {
        
    }
    public void upDateBestHand(ArrayList<Card> commons)
    {
        ArrayList<Card> total;
        //total =  combine holecards with commons and call evaluate with al combinations.
        Evaluator.evaluateRank5(total)
                or
        Evaluator.evaluateRank6(total)
                or Evaluator.evaluateRank7(total)
    }
    public String getAction()
    {
        
    }
    
}
