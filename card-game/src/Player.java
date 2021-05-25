/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author Vinicius Jimenez
 */
public class Player{
    private ArrayList<Card> cardsOnHand = new ArrayList<>();
    private boolean hasCard;
    
    Player(){ }
    
    Player(ArrayList<Card> cards){
        this.cardsOnHand = cards;
        this.hasCard = true;
    }

    public Card playCard(int index) throws Exception {
        var cardPosition = index - 1;
        
        if(cardPosition > this.cardsOnHand.size() || cardPosition < 0){
            throw new Exception("Jogue uma carta válida, por favor");
        }
        
        if(!hasCard){
            throw new Exception("O jogador não tem nenhuma carta");
        }
    
        return this.cardsOnHand.get(cardPosition);
    }

    public void earnCard(Card card) {
        this.cardsOnHand.add(card);
    }


    public void loseCard(Card card) {
        this.cardsOnHand.remove(card);
    }

    /**
     * @return the cardsOnHand
     */
    public ArrayList<Card> getCardsOnHand() {
        return cardsOnHand;
    }

    /**
     * @param cardsOnHand the cardsOnHand to set
     */
    public void setCardsOnHand(ArrayList<Card> cardsOnHand) {
        this.cardsOnHand = cardsOnHand;
    }

    /**
     * @return the hasCard
     */
    public boolean hasCard() {
        return hasCard;
    }

    /**
     * @param hasCard the hasCard to set
     */
    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }
}
