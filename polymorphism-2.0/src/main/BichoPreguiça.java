/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Vinicius Jimenez
 */
public class BichoPreguiça extends Animal{
    //Metodos
    public void subirArvore(){
        System.out.println("Preguica subindo em arvores...");
    }

    @Override
    public void emitirSom(){
        System.out.println("AAAAAAHHHHZZZZ");
    }
}
