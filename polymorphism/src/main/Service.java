package main;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Vinicius Jimenez
 */

public abstract class Service {
    public String type, orderedBy, requestCode;
    public LocalDate requestDate, deliveryDate;
    public double price;

    public Service(){
        
    }
    
    public Service(String type, String orderedBy, LocalDate requestDate, LocalDate deliveryDate, double price){
        this.type = type;
        this.orderedBy = orderedBy;
        this.requestDate = requestDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
        
        this.requestCode = Integer.toString((int) (Math.random() * (1000 - 1 + 1) + 1));
    }
    
    public long getDurationTime(){
        return Period.between(this.requestDate, LocalDate.now()).getDays();
    }
    
    public Map getServiceInfo(){
        var data = new HashMap<String, String>();
        
        data.put("type", this.type);
        data.put("orderedBy", this.orderedBy);
        data.put("requestCode", this.requestCode);
        data.put("requestDate", this.requestDate.toString());
        data.put("deliveryDate", this.deliveryDate.toString());
        data.put("price", Double.toString(this.price));
        data.put("durationTime", Long.toString(this.getDurationTime()));   
        
        return data;
    }
    
    public abstract String getRequestCode();
}
