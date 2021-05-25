


import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

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
    static public int generateRandomNumber(int max){
        var randomGenerator = new Random();
        
        return randomGenerator.nextInt(max);
    }
    
    static public String readInputFromConsole() throws Exception{
        var scanner = new Scanner(System.in);
        
        var result = scanner.nextLine();
        
        if(result.isEmpty() || result.isBlank()){
            throw new Exception("Você precisa informar um valor");
        }
        
        return result;
    }
    
    static public String timeAsString(long timeInMilliseconds){
        var seconds = Math.ceil(timeInMilliseconds / 1000.0);
        var minutes = Math.ceil(timeInMilliseconds / 60000.0);
        var hours = Math.ceil(timeInMilliseconds / 3600000.0);

        return (hours + ":" + minutes + ":" + seconds);
    }
    
}
