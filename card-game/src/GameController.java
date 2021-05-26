
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
    private GameState gameState; // Contém as informações mais recentes do Player e do Computador e é gerado a cada rodada
    private View view; // Métodos para impressão dos resultados
    
    GameController(Game game, GameState gameState, View view){
        this.game = game;
        this.gameState = gameState;
        this.view = view;
    }
    
    // Pegar o indíce da carta que o player jogou
    public int getPlayerCardChose(){
        var playerCardPosition = 0;
        
        // O uso do try-catch é necessário pq tanto o `Utils.readInputFromConsole` e o `Integer.parseInt` podem gerar `Exceptions`
        try{
            playerCardPosition = Integer.parseInt(Utils.readInputFromConsole());
        }
        catch(Exception exp){
            // Como são duas Exceptions diferentes e são instâncias de `Exception` eu diferencio elas pela menssagem
            
            if(exp.getMessage().equals("Você precisa informar um valor")){
                this.view.displayMessageError(exp.getMessage());
            }
            else{
                this.view.displayMessageError("Você deve inserir um número.");
            }
            
            this.playRound();
        }
        
        return playerCardPosition;
    }
    
    // Método que verifica qual carta é a maior e retorna a maior carta
    
    public Card verifyBiggerCard(Card firstOpt, Card secondOpt){
        var specialCards = this.getGameState().getSpecialCards();
        
        // Essa era a importância do `Deck.cards` ser inicializado na devida ordem e não sofrer nenhuma alteração
        // Nesse ponto, eu pego os índices das duas cartas e uso com o verificador de qual é o melhor
        
        var firstOptionIndex = Deck.getCards().indexOf(firstOpt);
        var secondOptionIndex = Deck.getCards().indexOf(secondOpt);
        
        // Primeiro eu verifico qual é a maior pelo index e depois verifico se a menor carta não é uma carta especial, uma manilha
        
        if(firstOptionIndex > secondOptionIndex){
            var isSecondOptAnSpecialCard = specialCards.contains(secondOpt);
            
            return isSecondOptAnSpecialCard ? secondOpt : firstOpt;
        }
        else if(firstOptionIndex < secondOptionIndex){
            var isFirstOptAnSpecialCard = specialCards.contains(firstOpt);
            
            return isFirstOptAnSpecialCard ? firstOpt : secondOpt;
        }
        else {
            // Caso elas sejam iguais, eu retorno uma carta nova vazia
            
            return new Card();
        }
 
    }
    
    public void playRound(){
        // Criando um estado novo a cada Round
        this.gameState = GameController.createGameState(this.game);
        
        // Verifica se o 
        if(this.gameState.isEnded()){
            var winner = this.gameState.getPlayerQttCards() == 0 ? this.game.getComputer() : this.game.getPlayer();

            this.gameState.setWinner(winner);
        }
        else{
                   
            // Mostrando o vira, as manilhas, a quantidade de cartas dos jogadores e as cartas do jogador
            this.view.displayGame(this.gameState);

            var playerCardChose = this.getPlayerCardChose();
            var computerCardChose = Utils.generateRandomNumber(getGameState().getComputerQttCards());

            try{
                var playerCard = this.game.getPlayer().playCard(playerCardChose);
                var computerCard = this.game.getComputer().playCard(computerCardChose);

                var winnerCard = this.verifyBiggerCard(playerCard, computerCard);

                // Verificando qual `Player` ganhou e se um ganhou

                var hasPlayerWon = winnerCard.equals(playerCard);
                var hasComputerWon = winnerCard.equals(computerCard);

                var turnedCard = this.getGameState().getTurnedCard();

                // Aqui caso o player tenha ganhado ele recebe a carta do computador e senão ele perde a carta para o computador
                if(hasPlayerWon){
                    this.game.getPlayer().earnCard(computerCard);
                    this.game.getComputer().loseCard(computerCard);
                }
                else if(hasComputerWon){
                    this.game.getComputer().earnCard(playerCard);
                    this.game.getPlayer().loseCard(playerCard);
                }
                
                // Na hora de mostrar o vencedor eu verifico se um player venceu, se sim eu mostro vitória ou derrota para o Player
                // Se não eu mostro empate
                
                if(hasComputerWon || hasPlayerWon){
                    this.view.displayRoundWinner(turnedCard, playerCard, computerCard, hasPlayerWon);
                }
                else {
                    this.view.displayRoundWinner(turnedCard, playerCard, computerCard);
                }

            }
            catch(Exception excp){
                this.view.displayMessageError(excp.getMessage());

                this.playRound();
            }
        }
 
    }
    // Métodos estático que recebe um `game` como parametro e cria um `gameState` todo round
    // O `gameState` é muito importante na View, pois o gameState passa somente as informações que a View precisa e nada mais
    static private GameState createGameState(Game game){
        var turnedCard = Deck.generateTurnedCard();
        var specialCards = Deck.generateSpecialCards(turnedCard);
        
        var playerCards = game.getPlayer().getCardsOnHand();
        var computerCards = game.getComputer().getCardsOnHand();
        
        var gameState = new GameState(playerCards, computerCards, turnedCard, specialCards);
        
        return gameState;
    }
    
    static public void initialize(){
        Deck.initialize(); // Inicializando o baralho
        
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
        
        // Enquanto o `gameState.isEnded` for false, ele continuará jogando
        // Dessa forma o `gameState` tem que ser atualizado a cada rodada
        
        while(!controller.getGameState().isEnded()){
            controller.playRound();
        }
        
        controller.getGame().setFinishedAt(System.currentTimeMillis());      

        // Verificando se o ganhador foi o Player ou o Computador
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
