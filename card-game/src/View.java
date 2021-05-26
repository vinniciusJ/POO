import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Jimenez
 */
public class View {
    static final private HashMap<String, String> COLORS = new HashMap<String, String>(){{
        put("reset", "\u001B[0m");
        put("red", "\u001B[31m");
        put("green", "\u001B[32m");
    }};
    
    static private String changeStringColor(String color, String text){
        return View.COLORS.get(color) + text + View.COLORS.get("reset");
    }
    
    static private boolean verifyCardSuit(Card card){
        return card.getSuit().equals("♦") || card.getSuit().equals("♥");
    }
    
    static private String setCardColorsBySuit(Card card){
        var status = View.verifyCardSuit(card);
        
        return changeStringColor(status ? "red" : "reset", card.toString());
    }
    
    // Método que configura a cor da String das cartas do naipe ♦ e ♥ para vermelho
    static private ArrayList<String> setCardsColorsBySuit(ArrayList<Card> cards){
        var coloredCards = new ArrayList<String>();
        
        cards.forEach((card) -> {
            if(View.verifyCardSuit(card)){
                coloredCards.add(changeStringColor("red", card.toString()));
            }
            else{
                coloredCards.add(card.toString());
            }
        });
        
        return coloredCards;
    }
    
    public void displayGame(GameState state){
        var coloredCards = View.setCardsColorsBySuit(state.getPlayerCards());
        var coloredTurnedCard = View.setCardColorsBySuit(state.getTurnedCard());
        var coloredSpecialCards = View.setCardsColorsBySuit(state.getSpecialCards());

        var message = (
            "JOGOS DAS CARTAS \n\n" + 
            "Vira: " + coloredTurnedCard + "\n" + 
            "Manilhas: " + String.join(" - ", coloredSpecialCards) + "\n\n" +   
            "Quantidade de cartas do computador: " + state.getComputerQttCards() + "\n" + 
            "Quantidade de cartas do player (você): " + state.getPlayerQttCards()+ "\n\n" + 
            "Suas Cartas:\n" + String.join(" - ", coloredCards) + "\n"
        );
        
        System.out.println(message);
        System.out.print("Informe a posição da carta que deseja jogar (1 - " + state.getPlayerQttCards() + "): ");
    }
    
    public void displayMessageError(String message){
        var coloredMessage = changeStringColor("red", message);
        
        System.out.println(coloredMessage);
    }
   
    
    public void displayRoundWinner(Card turnedCard, Card playerCard, Card computerCard, boolean hasPlayerWon){
        var coloredTurnedCard = View.setCardColorsBySuit(turnedCard);
        var coloredPlayerCard = View.setCardColorsBySuit(playerCard);
        var coloredComputerCard = View.setCardColorsBySuit(computerCard);
        
        var message = (
            (hasPlayerWon ? changeStringColor("green", "VOCÊ VENCEU O ROUND!") : changeStringColor("red", "VOCÊ PERDEU O ROUND!")) + "\n\n" + 
            "Vira: " + coloredTurnedCard + "\n" + 
            "Carta do computador: " + coloredComputerCard + "\n" + 
            "Sua Carta: " + coloredPlayerCard + "\n"
        );
        
        System.out.println(message);
        System.out.println("-------------------------------\n");
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.exit(1);
        }
    }
    
    public void displayRoundWinner(Card turnedCard, Card playerCard, Card computerCard){
        var coloredTurnedCard = View.setCardColorsBySuit(turnedCard);
        var coloredPlayerCard = View.setCardColorsBySuit(playerCard);
        var coloredComputerCard = View.setCardColorsBySuit(computerCard);
        
        var message = (
            "O ROUND TERMINOU EMPATADO\n\n" + 
            "Vira: " + coloredTurnedCard + "\n" + 
            "Carta do computador: " + coloredComputerCard + "\n" + 
            "Sua Carta: " + coloredPlayerCard + "\n"
        );
        
        System.out.println(message);
        System.out.println("-------------------------------\n");
        
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.exit(1);
        }
    }
    
    
    public void displayGameWinner(boolean hasPlayerWon, long timeSpent){
        var timeSpentAsString = Utils.timeAsString(timeSpent);
        
        var message = (
        (hasPlayerWon ? changeStringColor("green", "VOCÊ É O VENCEDOR!") : changeStringColor("red", "O COMPUTADOR É O VENCEDOR!")) + "\n\n" +
        "Duração do jogo: " + timeSpentAsString
        );
        
        System.out.println(message);
    }
}
