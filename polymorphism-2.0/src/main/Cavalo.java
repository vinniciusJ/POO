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
public class Cavalo extends Animal{
    //Metodos
    @Override
    public void correr(){
        System.out.println("Cavalo correndo...");
    }

    @Override
    public void emitirSom(){
        System.out.println("IRRRIINN");
    }
}
