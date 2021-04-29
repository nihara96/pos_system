/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingsystem;

import java.io.Serializable;

import java.util.ArrayList;



/**
 *
 * @author User
 */
public class Buisiness implements Serializable {
 
   private ArrayList<String> itemName = new ArrayList<>();
   private ArrayList<String> quantity = new ArrayList<>(); 
  private String date; 

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
  
  
    public ArrayList<String> getItemName() {
        return itemName;
    }

    public void setItemName(ArrayList<String> itemName) {
        this.itemName = itemName;
    }

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<String> quantity) {
        this.quantity = quantity;
    }
    
    
    
}
