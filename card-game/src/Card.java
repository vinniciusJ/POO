/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vinicius Jimenez
 */
public class Card {
    // Declarando o valor e o naipe de cada carta
    private String value, suit;
    
    Card(){ }
    
    Card(String value, String suit){
        this.value = value;
        this.suit = suit;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return this.value + this.suit;
    }
}
