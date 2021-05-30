import java.util.Timer;
import java.util.TimerTask;

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
    private GameState state;
    private GameView view;
 
    GameController(GameState state, GameView view){
        this.state = state;
        this.view = view;
    }
    
    public void runGame(){
        this.state.updateAll(900);
        this.view.displayGame(this.state.getSquares());
    }
    
    static public void initialize(){
        final var squaresQtty = 6;
        
        var state = GameState.initialize(squaresQtty);
        var view = GameView.initialize(900, (squaresQtty * 100 + 20));
        
        var controller = new GameController(state, view);
        
        var timer = new Timer();
        
        var task = new TimerTask() {
            @Override
            public void run() {
                if(!controller.state.hasWinners()){
                    controller.runGame();
                }
                else{
                    timer.cancel();
                    timer.purge();  
                }   
            }
        };
        
        timer.scheduleAtFixedRate(task, 0, 1000);
  
    }

    /**
     * @return the state
     */
    public GameState getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(GameState state) {
        this.state = state;
    }

    /**
     * @return the view
     */
    public GameView getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(GameView view) {
        this.view = view;
    }
}
