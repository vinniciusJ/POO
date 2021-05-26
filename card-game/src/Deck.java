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
    // O array `cards` é definido como private para não sofrer modificações depois que inicializado 
    // Para ter acesso ao valor dentro do array, usei o método estático `Deck.getCards`
    static final private ArrayList<Card> cards = new ArrayList<>();
    
    static final public ArrayList<String> VALUES = new ArrayList<>(List.of("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));
    static final public ArrayList<String> SUITS = new ArrayList<>(List.of("♦", "♠", "♥", "♣"));
    
    static public void initialize(){
        // Atribuindo os valores de forma que a verificação de maior carta possa ocorrer verificando os indíces dos valores no array `cards`
        VALUES.forEach(value -> {
            SUITS.stream().map(suit -> new Card(value, suit)).forEachOrdered(card -> {
                cards.add(card);
            });
        });
        
    }
    
    // Gerar um "vira" aleatório
    static public Card generateTurnedCard(){
        return cards.get(Utils.generateRandomNumber(cards.size()));
    }
    
    // Como foi usado um array plano, temos que fazer uma verificação a mais para pegarmos exatamente o index da próxima carta com o naipe igual a ♦
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
    
    // Gerando a as "manilhas" para cada round
    static public ArrayList<Card> generateSpecialCards(Card turnedCard){
        var startSpecialCardsIndex = getNextIndexBySuit(cards.indexOf(turnedCard), turnedCard.getSuit());
        
        // Pegando a subList do naipe ♦ até o ♣
        var specialCards = new ArrayList<Card>(cards.subList(startSpecialCardsIndex, startSpecialCardsIndex + 4)) ;
        
        return specialCards;
    }
    
    // Embaralhando o baralho e devolvendo um novo baralho embaralhado, mantendo assim o cards sem modificações
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
