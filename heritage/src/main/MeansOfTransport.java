package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vinicius Jimenez
 */
public class MeansOfTransport {

    public String typeFuel, locomotion, brand, model;
    public double weight;
    public int releaseYear, maxLitersInTank;
    
    public int qttLitersInTank = 0;
    public boolean isStarted, isMoving;
    
    public MeansOfTransport(){ }
    public MeansOfTransport(HashMap<String, String> data){ }
   
    public MeansOfTransport(MeansOfTransport mt){
        this.typeFuel = mt.typeFuel;
        this.brand = mt.brand;
        this.model = mt.model;
        this.weight = mt.weight;
        this.releaseYear = mt.releaseYear;
        this.maxLitersInTank = mt.maxLitersInTank;
    }
   
    
    public void fuel(int liters) throws Exception{
        if((this.qttLitersInTank + liters) > this.maxLitersInTank){
            throw new Exception("O tanque suporta apenas " + this.maxLitersInTank + " de litros.");
        }
        
        if(this.isStarted){
             throw new Exception("Não pode abastacer enquanto estiver ligado.");
        }
        
        this.qttLitersInTank += liters;
    }
    
    public boolean start() throws Exception{
        if(this.isStarted){
            throw new Exception("O carro já está ligado.");
        }
        
        this.isStarted = true;
        
        return this.isStarted;
    }
    
    public boolean turnOff() throws Exception{
        if(!this.isStarted){
            throw new Exception("O carro já está desligado");
        }
        
        this.isStarted = false;
        
        return this.isStarted;
    }
    
    public boolean move() throws Exception{
        if(!this.isStarted){
            throw new Exception("Primeiro você deve ligar o carro.");
        }
       
        if(this.qttLitersInTank - 10 <= 0){
            throw new Exception("Combustível insuficiente, por favor abasteça!");
        }
        
        if(this.isMoving){
            throw new Exception("O carro já está se movendo.");
        }
        
        this.isMoving = true;
        this.qttLitersInTank -= 10;
        
        return this.isMoving;
    }
    
    public boolean stopMoving() throws Exception{
        if(!this.isMoving){
             throw new Exception("O carro já está parado.");
        }
        
        this.isMoving = false;
        
        return this.isMoving;
    }
    
    public Map getMeansOfTransportInfo(){
        var data = new HashMap<Object, Object>();
        
        data.put("type", this.locomotion);
        data.put("brand", this.brand);
        data.put("model", this.model);
        data.put("releaseYear", this.releaseYear);
        data.put("weight", this.weight);
        data.put("typeFuel", this.typeFuel);
        data.put("maxLitersInTank", this.maxLitersInTank);
        
        return data;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return (
            "Tipo: " + this.locomotion + "\n" +
            "Marca: " + this.brand + "\n" +
            "Modelo: " + this.model + "\n" + 
            "Ano de lançamento: " + this.releaseYear + "\n" +
            "Peso: " + this.weight + " Kg \n" +
            "Tipo de combustível: " + this.typeFuel + "\n" +
            "Quantidade máxima de litros no tanque: " + this.maxLitersInTank + " Litros \n"
        );
    }
    
}
