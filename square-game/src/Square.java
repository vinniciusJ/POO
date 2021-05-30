
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Jimenez
 */
public class Square extends JPanel{
    private Rectangle position;
    private Color bgColor;
    private int speed;
    private boolean isVisible;
    
    Square(Rectangle position, int speed, Color bgColor){
        this.position = position;
        this.bgColor = bgColor; 
        this.isVisible = false;
        this.speed = speed;
        
        this.setBounds(position);
        this.setBackground(bgColor);
    }
    
    public void init(){
        this.setVisible(!this.isVisible);
    }
    
    public void update(){
        this.position = new Rectangle((this.position.x + this.speed), this.position.y, this.position.width, this.position.height);

        this.setBounds(this.position);
    }
    
    public void update(int times){
        this.position = new Rectangle((this.position.x + times), this.position.y, this.position.width, this.position.height);

        this.setBounds(this.position);
    }

    /**
     * @return the position
     */
    public Rectangle getPosition() {
        return position;
    }

    /**
     * @param bounds the position to set
     */
    public void setPosition(Rectangle bounds) {
        this.position = bounds;
    }

    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }


    /**
     * @return the isVisible
     */
    public boolean isIsVisible() {
        return isVisible;
    }

    /**
     * @param isVisible the isVisible to set
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
