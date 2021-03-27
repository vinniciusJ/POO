/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;

/**
 *
 * @author Vinicius Jimenez
 */
public class Controller {
    private View view;
    private MeansOfTransport meansOfTransport;
    
    public Controller(){
        this.view = new View();
        this.meansOfTransport = new MeansOfTransport();
    }
    
    static Controller initalize(){
        var instance = new Controller();
        
        instance.init();
        
        return instance;
    }
    
    private void init(){
        String[] options = {"Automóvel", "Avião", "Branco", "Sair"};
        String defaultMessageType = "question", selectedOpt;
        int mtType;
        
        var selectedOptsMt = new HashMap<String, String>();
        
        this.view.showOptionInput("Escolha um meio de transporte", "Meios de Transporte", options, options, "first-input");
        
        selectedOpt = options[(int) this.view.getDataFrom("first-input")];
        
        if(selectedOpt.equals("Sair")){
            System.exit(0);
        }
        
        this.view.showInput("Informe a Marca:", "Marca", defaultMessageType, "mt-brand");
        this.view.showInput("Informe o modelo:", "Modelo", defaultMessageType, "mt-model");
        this.view.showInput("Informe o ano de lançamento:", "Ano de lançamento", defaultMessageType, "mt-release-year");
        this.view.showInput("Informe o peso (Kg):", "Peso", defaultMessageType, "mt-weight");
        this.view.showInput("Informe o tipo de combustível: ", "Combustível", defaultMessageType, "mt-fuel");
        this.view.showInput("Informe o max. de litros no tanque:", "Tanque", defaultMessageType, "mt-max-qtt-litters");
        
        selectedOptsMt.put("type", selectedOpt);
        selectedOptsMt.put("fuel", (String) this.view.getDataFrom(("mt-fuel")));
        selectedOptsMt.put("model", (String) this.view.getDataFrom("mt-model"));
        selectedOptsMt.put("brand", (String) this.view.getDataFrom("mt-brand"));
        selectedOptsMt.put("release-year",(String) this.view.getDataFrom("mt-release-year"));
        selectedOptsMt.put("weight", (String) this.view.getDataFrom("mt-weight"));
        selectedOptsMt.put("max-litters-in-tank", (String) this.view.getDataFrom("mt-max-qtt-litters"));
        
        
        mtType = (int) this.view.getDataFrom("first-input");
        
        switch(mtType){
            case 0 -> this.meansOfTransport = new Car(selectedOptsMt);
            case 1 -> this.meansOfTransport = new Airplane(selectedOptsMt);
            case 2 -> this.meansOfTransport = new Ship(selectedOptsMt);
            default -> this.meansOfTransport = new MeansOfTransport(selectedOptsMt);
        }
        
        System.out.println(this.meansOfTransport.typeFuel);
        
        this.showActions();
    }
    
    
    private void showActions(){
        String[] options = {"Ligar/Desligar", "Abastecer", "Mover", "Parar", "Mostar informações", "Sair"};
        int selectedOpt;
        
        this.view.showOptionInput("O que deseja fazer?", "Ações", options, options[0], "selected-opt");
        
        selectedOpt = (int) this.view.getDataFrom("selected-opt");
        
        switch(selectedOpt){
            case 0 -> this.setIsStarted();
            case 1 -> this.fuelMeansOfTransport();
            case 2 -> this.moveMeansOfTransport(1);
            case 3 -> this.moveMeansOfTransport(0);
            case 4 -> this.showMeansOfTransportInfo();
            default -> System.exit(0);
        }
    }
    
    private void showMeansOfTransportInfo(){
        this.view.showMessage(this.meansOfTransport, ("Informações do " + this.meansOfTransport.locomotion), "info");
    } 
    
    private void moveMeansOfTransport(int opt){
        try{
            if(opt == 0){
                this.meansOfTransport.stopMoving();
                this.view.showMessage("O " + this.meansOfTransport.locomotion + " está parado.");
            }
            else{
                this.meansOfTransport.move();
                this.view.showMessage("O " + this.meansOfTransport.locomotion + " está se movendo.");
            }
        }
        catch(Exception excep){
            this.view.showMessage(excep.getMessage(), "Erro", "error");
        }
        
        this.showActions();
    }
    
    private void fuelMeansOfTransport(){
        this.view.showInput("Informe quantos litros deseja abastecer:", "Abastecer", "info", "qtt-liters");
        
        int qttLiters = Integer.parseInt((String) this.view.getDataFrom("qtt-liters"));
        
        try{
            this.meansOfTransport.fuel(qttLiters);
            
            this.view.showMessage(("Quantidade de litros no tanque: " + this.meansOfTransport.qttLitersInTank + " litros"), "Qtd. de litros no tanque", "info");
        }
        catch(Exception excep){
            this.view.showMessage(excep.getMessage(), "Erro ao abastecer", "error");
        }
        
        this.showActions();
    }
    
    private void setIsStarted(){
        String[] options = {"Ligar", "Desligar"};
        int selectedoOpt;
        boolean status = false;
        
        this.view.showOptionInput("Escolha uma opção:", "Desligar/Ligar", options, options[0], "start-turnoff");
        
        selectedoOpt = (int) this.view.getDataFrom("start-turnoff");
        
        try{
            if(selectedoOpt == 0){
                status = this.meansOfTransport.start();
            }
            else{
                status = this.meansOfTransport.turnOff();
            }
        }
        catch(Exception excep){
            this.view.showMessage(excep.getMessage(), "Aviso", "warning");
        }
        
        this.view.showMessage((status ? "O carro está ligado." : "O carro foi desligado."), "Sucesso", "simple");
        
        this.showActions();
    }
}
