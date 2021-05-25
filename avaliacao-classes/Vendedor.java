/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Date;

/**
 *
 * @author Vinicius Jimenez
 */
public class Vendedor extends Funcionario{
    private static final float SALARIO = 2000F;
    private EquipeVenda equipe;

    Vendedor(String nome, Date dataNasc, String cpf, Endereco endereco, EquipeVenda equipe){
        this.setNome(nome);
        this.setDataNascimento(dataNasc);
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.equipe = equipe;
    }
    
    public float getSalario(){
        return Vendedor.SALARIO;
    }

    /**
     * @return the equipe
     */
    public EquipeVenda getEquipe() {
        return equipe;
    }

    /**
     * @param equipe the equipe to set
     */
    public void setEquipe(EquipeVenda equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        var dataNasc = this.getDataNascimento();
        var dataNascFormatada  = dataNasc.getDay() + "/" + dataNasc.getMonth() + "/"  + dataNasc.getYear(); 
        
        return (
                "Nome: " + this.getNome() + "\n" +
                "CPF: " + this.getCpf()+ "\n" +
                "Data Nascimento: " + dataNascFormatada + "\n" +
                "Endereço: " + this.getEndereco()+ "\n" +
                "Cargo: Vendedor \n" +
                "Equipe: " + this.equipe.getNome() + "\n" + 
                "Salário: " + this.getSalario() + "\n"
        );
    }
    
    
}
