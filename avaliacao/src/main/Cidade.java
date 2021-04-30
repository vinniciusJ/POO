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
public class Cidade {
    private String nome;
    private Estado estado;
    
    Cidade(String nome, Estado estado){
        this.nome = nome;
        this.estado = estado;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return this.nome + " - " + this.estado;
    }
}
