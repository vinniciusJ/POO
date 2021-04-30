/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Vinicius Jimenez
 */
public class Zoologico {
    public List animais = new ArrayList<Animal>();
    
    public static void main(String[] args) {
        var zoo = new Zoologico();
        
        for(var i = 0; i < 10; i++){
            if(zoo.animais.isEmpty()){
                zoo.animais.add(new Cavalo());
            }
            else if(zoo.animais.get(zoo.animais.size() - 1).getClass() == (new Cavalo().getClass())){
                zoo.animais.add(new Cachorro());
            }
            else if(zoo.animais.get(zoo.animais.size() - 1).getClass() == (new Cachorro().getClass())){
                zoo.animais.add(new BichoPreguiça());
            }
            else{
                zoo.animais.add(new Cavalo());
            }
        }
        
        Iterator<Animal> iterator = zoo.animais.iterator();
        
        while(iterator.hasNext()){
            Animal animal = iterator.next();
            Boolean podeCorrer = animal.getClass() == (new Cachorro().getClass()) || animal.getClass() == (new Cavalo().getClass());
            
            animal.emitirSom();
            
            if(podeCorrer){
                animal.correr();
            }
            
            System.out.println("------------------");
        }
    }
}
