package main;

import java.awt.Component;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Vinicius Jimenez
 */
public class View {
    
    private static final Component parentComponent = null;
    private final Map MESSAGE_TYPES = new HashMap<String, Integer>();
    private final Map STATE = new HashMap<String, Object>();
    
    public View(){
        MESSAGE_TYPES.put("error", JOptionPane.ERROR_MESSAGE);
        MESSAGE_TYPES.put("info", JOptionPane.INFORMATION_MESSAGE);
        MESSAGE_TYPES.put("warning", JOptionPane.WARNING_MESSAGE);
        MESSAGE_TYPES.put("question", JOptionPane.QUESTION_MESSAGE);
        MESSAGE_TYPES.put("simple", JOptionPane.PLAIN_MESSAGE); 
    }
    
    private boolean verifyStateKeyExistance(String key){
        var isKeyOnState = false;
        
        Iterator<Map.Entry<String, String>> iterator = this.STATE.entrySet().iterator();
        
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            
            if(key.equals(entry.getKey())){
                isKeyOnState = true;
            }
        }
        
        return isKeyOnState;
    }
    
    private void addInputOnState(String key, Object value){
        if(verifyStateKeyExistance(key)){
           STATE.replace(key, value);
        }
        else {          
           STATE.put(key, value);
        }
    }

    
    public void showMessage(Object message){
        JOptionPane.showMessageDialog(parentComponent, message);
    }
    
    public void showMessage(Object message, String title, String type){
        JOptionPane.showMessageDialog(parentComponent, message, title, (int) MESSAGE_TYPES.get(type));
    }
    
    public static void showInput(Object message){
        JOptionPane.showInputDialog(parentComponent, message);
    }
    
    public void showInput(Object message, String title, String type, String nameState){
        var value = JOptionPane.showInputDialog(parentComponent, message, title, (int) MESSAGE_TYPES.get(type));
        
        addInputOnState(nameState, value);
    }
    
    public void showOptionInput(String message, String title, Object[] options, Object initialValue, String nameState){
        var value = JOptionPane.showOptionDialog(
            parentComponent, message, title, JOptionPane.NO_OPTION, (int) MESSAGE_TYPES.get("simple"), null, options, initialValue
        );
       
        addInputOnState(nameState, value);
    }
    
    public Object getDataFrom(String key){
       return STATE.get(key);
    }
    
    public void cleanDataCache(){
        STATE.clear();
    }
}
