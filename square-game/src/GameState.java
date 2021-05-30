import java.awt.Color;
import java.awt.Rectangle;
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
    private final ArrayList<Square> squares;
    private final ArrayList<Square> podium;
    private boolean hasWinners;
        
    GameState(ArrayList<Square> squares){
        this.squares = squares;
        this.podium = new ArrayList<>();
        this.hasWinners = false;
    }
    
    public void updateAll(int max){
        var squaresOutOfPodium = new ArrayList<Square>();
        
        this.squares.forEach(square -> {
            if(!this.podium.contains(square)){
                squaresOutOfPodium.add(square);
            }
        });
        
        squaresOutOfPodium.forEach(square -> {
            var currentRightBound = square.getPosition().x + square.getPosition().width;
            var nextRightBound = currentRightBound + square.getSpeed();

            if(nextRightBound >= max){
                var times = max - currentRightBound;

                if(currentRightBound < max){
                    square.update(times);
                }

                this.setPodiumPositions(square);
            }
            else{
                square.update();
            }
        });
    }
    
    public void setPodiumPositions(Square selectedSquare){
        if(this.podium.size() < 2){
            selectedSquare.setSpeed(0);
        
            this.podium.add(selectedSquare);
        }
        else{
            this.squares.forEach(square -> {
                square.setSpeed(0);
            });
            
            this.podium.add(selectedSquare);
            this.hasWinners = true;
        }
    }
    
    static GameState initialize(int qtty){
        var squares =  new ArrayList<Square>();
        var generatedColors = new ArrayList<Color>();
        var generatedSpeeds =  new ArrayList<Integer>();
        
        int width = 100,  height = 100, y = 0;
        
        for(int i = 0; i < qtty; i++){
            var position = new Rectangle(0, y, width, height);
            var color = Utils.generateRandomColor();
            var randomSpeed = Utils.generateRandomNumber(10, 30);
            
            while(generatedSpeeds.contains(randomSpeed)){
                randomSpeed = Utils.generateRandomNumber(10, 30);
            }
            
            while(generatedColors.contains(color)){
                color = Utils.generateRandomColor();
            }

            var square = new Square(position, randomSpeed, color);
            
            square.init();
            
            squares.add(square);
            generatedColors.add(color);
            generatedSpeeds.add(randomSpeed);
            
            y += height;
        }
        
        return new GameState(squares);
    }

    /**
     * @return the squares
     */
    public ArrayList<Square> getSquares() {
        return squares;
    }


    /**
     * @return the podium
     */
    public ArrayList<Square> getPodium() {
        return podium;
    }

    /**
     * @return the hasWinners
     */
    public boolean hasWinners() {
        return hasWinners;
    }
}
