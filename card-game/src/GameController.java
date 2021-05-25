
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
public class GameController {
    private Game game;
    private GameState gameState;
    private View view;
    
    GameController(Game game, GameState gameState, View view){
        this.game = game;
        this.gameState = gameState;
        this.view = view;
    }
    
    public int getPlayerCardChose(){
        var playerCardPosition = 0;
        
        try{
            playerCardPosition = Integer.parseInt(Utils.readInputFromConsole());
        }
        catch(Exception exp){
            if(exp.getMessage().equals("Você precisa informar um valor")){
                this.view.displayMessageError(exp.getMessage());
            }
            else{
                this.view.displayMessageError("Você deve inserir um número.");
            }
            
            this.play();
        }
        
        return playerCardPosition;
    }
    
    public Card verifyBiggerCard(Card firstOpt, Card secondOpt){
        var specialCards = this.getGameState().getSpecialCards();
        
        var firstOptionIndex = Deck.getCards().indexOf(firstOpt);
        var secondOptionIndex = Deck.getCards().indexOf(secondOpt);
        
        if(firstOptionIndex == secondOptionIndex){
            var suitFirstOptionIndex = Deck.SUITS.indexOf(firstOpt.getSuit());
            var suitSecondOptionIndex = Deck.SUITS.indexOf(firstOpt.getSuit());
            
            if(suitFirstOptionIndex > suitSecondOptionIndex){
                return firstOpt;
            }
            else if(suitFirstOptionIndex < suitSecondOptionIndex){
                return secondOpt;
            }
        }
        else if(firstOptionIndex > secondOptionIndex){
            var isSecondOptAnSpecialCard = specialCards.contains(secondOpt);
            
            return isSecondOptAnSpecialCard ? secondOpt : firstOpt;
        }
        else if(firstOptionIndex < secondOptionIndex){
            var isFirstOptAnSpecialCard = specialCards.contains(firstOpt);
            
            return isFirstOptAnSpecialCard ? firstOpt : secondOpt;
        }
        
        return firstOpt;
    }
    
    public void play(){
        this.gameState = GameController.createGameState(this.game);
        
        this.view.displayGame(getGameState());
        
        var playerCardChose = this.getPlayerCardChose();
        var computerCardChose = Utils.generateRandomNumber(getGameState().getComputerQttCards());
        
        try{
            var playerCard = this.game.getPlayer().playCard(playerCardChose);
            var computerCard = this.game.getComputer().playCard(computerCardChose);
            
            var winnerCard = this.verifyBiggerCard(playerCard, computerCard);
            var hasPlayerWon = winnerCard.equals(playerCard);
            
            var turnedCard = this.getGameState().getTurnedCard();
            
            if(hasPlayerWon){
                this.game.getPlayer().earnCard(computerCard);
                this.game.getComputer().loseCard(computerCard);
            }
            else{
                this.game.getComputer().earnCard(playerCard);
                this.game.getPlayer().loseCard(playerCard);
            }
           
            if(this.gameState.isEnded()){
                var winner = this.gameState.getPlayerQttCards() == 0 ? this.game.getComputer() : this.game.getPlayer();
                
                this.gameState.setWinner(winner);
            }
            
            this.view.displayRoundWinner(turnedCard, playerCard, computerCard, hasPlayerWon);
        }
        catch(Exception excp){
            this.view.displayMessageError(excp.getMessage());
            
            //this.play();
        }
    }
    
    static private GameState createGameState(Game game){
        var turnedCard = Deck.generateTurnedCard();
        var specialCards = Deck.generateSpecialCards(turnedCard);
        
        var playerCards = game.getPlayer().getCardsOnHand();
        var computerCards = game.getComputer().getCardsOnHand();
        
        var gameState = new GameState(playerCards, computerCards, turnedCard, specialCards);
        
        return gameState;
    }
    
    static public void initialize(){
        Deck.initialize();
        
        var shuffledDeck = Deck.getShuffledDeck();
        
        // Transformando o retorno de `.subList` em um ArrayList
        var playerCards = new ArrayList<Card>(shuffledDeck.subList(0, ((int) shuffledDeck.size() / 2)));
        var computerCards = new ArrayList<Card>(shuffledDeck.subList(((int) shuffledDeck.size() / 2), shuffledDeck.size()));
        
        var player = new Player(playerCards);
        var computer = new Player(computerCards);
        
        var game = new Game(player, computer);
        var view = new View();
        var gameState = GameController.createGameState(game);
        
        var controller = new GameController(game, gameState, view);
        
        while(!controller.getGameState().isEnded()){
            controller.play();
        }
        
        controller.getGame().setFinishedAt(System.currentTimeMillis());      

        var hasPlayerWon = controller.gameState.getWinner().equals(controller.game.getPlayer());
        var timeSpent = controller.game.getFinishedAt() - controller.game.getStartedAt();
              
        controller.view.displayGameWinner(hasPlayerWon, timeSpent);
    }

    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @param game the game to set
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * @return the view
     */
    public View getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * @return the gameState
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * @param gameState the gameState to set
     */
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
