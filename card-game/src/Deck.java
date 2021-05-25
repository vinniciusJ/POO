/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Vinicius Jimenez
 */
// Baralho
public class Deck {
    static final private ArrayList<Card> cards = new ArrayList<>();
    
    static final public ArrayList<String> VALUES = new ArrayList<>(List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
    static final public ArrayList<String> SUITS = new ArrayList<>(List.of("♦", "♠", "♥", "♣"));
    
    static public ArrayList<Card> initialize(){
        VALUES.forEach(value -> {
            SUITS.stream().map(suit -> new Card(value, suit)).forEachOrdered(card -> {
                cards.add(card);
            });
        });
        
        return cards;
    }
    
    static public Card generateTurnedCard(){
        return cards.get(Utils.generateRandomNumber(cards.size()));
    }
    
    static private int getNextIndexBySuit(int initialValue, String suit){
        var turnedCardIndex = initialValue;
        
        if(initialValue + 4 < cards.size()){
            turnedCardIndex = switch (suit) {
                case "♦" -> turnedCardIndex + 4;
                case "♠" -> turnedCardIndex + 3;
                case "♥" -> turnedCardIndex + 2;
                default -> turnedCardIndex + 1;
            };
        }
        else {
            turnedCardIndex = 0;
        }
        
        return turnedCardIndex;
    }
    
    // Gerando a carta "vira"
    static public ArrayList<Card> generateSpecialCards(Card turnedCard){
        var startSpecialCardsIndex = getNextIndexBySuit(cards.indexOf(turnedCard), turnedCard.getSuit());
        
        var specialCards = new ArrayList<Card>(cards.subList(startSpecialCardsIndex, startSpecialCardsIndex + 4)) ;
        
        return specialCards;
    }
    
    static public ArrayList<Card> getShuffledDeck(){
        var deck = new ArrayList<Card>(cards);      
        
        Collections.shuffle(deck);
 
        return deck;
    }

    /**
     * @return the cards
     */
    static public ArrayList<Card> getCards() {
        return cards;
    }
}
