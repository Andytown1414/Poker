/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pokerboi;

/**
 *
 * @author andre
 */

//TODO - ace is just 14 atm. so if you wanna use as a 1..... i guess the ONLY time it counts as a 1 is if you have 2,3,4,5. like in no other case is it useful to say its a 1.
public class Card {
    
    private String suit, symbol;
    private int value;
    
    
    public Card(String suit, String symbol){
        this.suit = suit;
        this.symbol = symbol;
        this.value = calcValue(symbol);
        
    }

    public String getSuit() {
        return suit;
        
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
    
    
    private int calcValue(String symbol)
    {
        // if string not correct, set value 99 to indicate error. maybe use enum for this instead if you want.
        int value = 99;
        
        switch(symbol){
            
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            case "T":
                value = 10;
                break;
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = 99;
            
            
        }
        
        return value;
    }
    
}
