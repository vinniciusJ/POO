/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.LocalDate;

/**
 *
 * @author Vinicius Jimenez
 */
public class Maintenance extends Service implements ServiceOptions{
    
    public Maintenance(){
        this.type = "maintenance";
    }

    @Override
    public String getRequestCode() {
        return  "maintenance" + this.requestCode;
    }

    @Override
    public void postponeDeliveryDate(LocalDate date) {
        if(date.getDayOfMonth() < 10){
            this.deliveryDate = date;
        }
        else{
            System.out.println("Não é possível adiar a manutenção por mais que 10 dias");
        }
    }

    @Override
    public void decreasePrice() {
        this.price = this.price - (this.price * 0.05);
    }

    @Override
    public void cancelService() {
        System.out.println("A manutenção foi cancelada com Sucesso");
    }
}
