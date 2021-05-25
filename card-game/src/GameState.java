
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Jimenez
 */
public class GameState {
    private final ArrayList<Card> playerCards,specialCards;
    private ArrayList<Card> computerCards;
    private final int computerQttCards, playerQttCards;
    private final Card turnedCard;
    private boolean isEnded;
    private Player winner;
    
    GameState(ArrayList<Card> playerCards, ArrayList<Card> computerCards, Card turnedCard, ArrayList<Card> specialCards){
         this.playerCards = playerCards;
         this.computerCards = computerCards;
         this.computerQttCards = computerCards.size();
         this.playerQttCards = playerCards.size();
         this.turnedCard = turnedCard;
         this.specialCards = specialCards;
         
         if(this.computerQttCards == 0 || this.playerQttCards == 0){
             this.isEnded = false;
         }
    }

    /**
     * @return the playerCards
     */
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    /**
     * @return the specialCards
     */
    public ArrayList<Card> getSpecialCards() {
        return specialCards;
    }

    /**
     * @return the computerQttCards
     */
    public int getComputerQttCards() {
        return computerQttCards;
    }

    /**
     * @return the playerQttCards
     */
    public int getPlayerQttCards() {
        return playerQttCards;
    }

    /**
     * @return the turnedCard
     */
    public Card getTurnedCard() {
        return turnedCard;
    }

    /**
     * @return the isEnded
     */
    public boolean isEnded() {
        return isEnded;
    }

    /**
     * @param isEnded the isEnded to set
     */
    public void setIsEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }

    /**
     * @return the winner
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * @return the computerCards
     */
    public ArrayList<Card> getComputerCards() {
        return computerCards;
    }

    /**
     * @param computerCards the computerCards to set
     */
    public void setComputerCards(ArrayList<Card> computerCards) {
        this.computerCards = computerCards;
    }
    
    
}
