/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Vinicius Jimenez
 */
public class Main {
    public static List<Estado> estados = List.of(new Estado("Paraná", "PR"), new Estado("São Paulo", "SP"));
    public static List<Cidade> cidades = List.of(new Cidade("Ponta Grossa", estados.get(0)), new Cidade("Campinas", estados.get(1)));
    
    public static void main(String[] args) {
        SimpleDateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        
        var vendedorEndereco = new Endereco("R. Joaquim Nabuco", 52, "Bairro do Shopping", "84030-475", cidades.get(0));
        var gerenteEndereco = new Endereco("R. Santo Antonio Claret", 52, "Jardim Chapadão", "86230-915", cidades.get(1));
        
        Date vendedorDataNasc, gerenteDataNasc;
        
        try{
            vendedorDataNasc = formatadorData.parse("26/09/1998");
            gerenteDataNasc = formatadorData.parse("21/01/1997");
        }
        catch(ParseException e){
            vendedorDataNasc = new Date();
            gerenteDataNasc = new Date();
            
            System.out.println(e);
        }

        
        var vendedor = new Vendedor("José Carlos", vendedorDataNasc, "000.000.000.96", vendedorEndereco, new EquipeVenda("Brinquedos"));
        var gerente = new Gerente("Maria Clara", gerenteDataNasc,  "000.000.000.91", gerenteEndereco);
        
        System.out.println(vendedor);
        System.out.println(gerente);
    }
}
