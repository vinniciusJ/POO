
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vinicius Jimenez
 */
public class Utils {
    static public int generateRandomNumber(int min, int max){ 
        return new Random().nextInt(max + 1 - min) + min;
    }
    
    static public int generateRandomNumber(int max){ 
        return new Random().nextInt(max);
    }
    
    
    static public Color generateRandomColor(){
        var colors = new ArrayList<Color>(List.of(Color.red, Color.yellow, Color.green, Color.magenta, Color.pink, Color.cyan, Color.orange));
        
        return colors.get(generateRandomNumber(colors.size()));
    }
}
