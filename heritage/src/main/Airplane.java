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
public class Airplane extends MeansOfTransport{
  
    Airplane(HashMap<String, String> data) {
        this.locomotion = "Avião";
        this.typeFuel = data.get("fuel");
        this.brand = data.get("brand");
        this.model = data.get("model");
        this.weight = Double.parseDouble(data.get("weight"));
        this.releaseYear = Integer.parseInt(data.get("release-year"));
        this.maxLitersInTank = Integer.parseInt(data.get("max-litters-in-tank"));
    }

    
}
