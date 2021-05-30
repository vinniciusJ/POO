/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Vinicius Jimenez
 */
public class GameView extends JFrame{
    GameView(){
        super("Corrida dos quadrados");

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void clearFrame(){
        this.removeAll();
    }
    
    public void displayGame(ArrayList<Square> squares){
        squares.forEach(square -> {
            this.add(square);
        });  
    }
    
    static public GameView initialize(int width, int height){
        var view = new GameView();

        view.setSize(width, height);
        view.setLayout(null);      
        view.setVisible(true);
         
        return view;
    }

}
