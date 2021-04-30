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
public class Gerente extends Funcionario{
    private static final float SALARIO = 3800F; 
    
    Gerente(String nome, Date dataNasc, String cpf, Endereco endereco){
        this.setNome(nome);
        this.setDataNascimento(dataNasc);
        this.setCpf(cpf);
        this.setEndereco(endereco);
    }
    
    public float getSalario(){
        return Gerente.SALARIO;
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
                "Cargo: Gerente \n" +
                "Salário: " + this.getSalario() + "\n"
        );
    }
}
