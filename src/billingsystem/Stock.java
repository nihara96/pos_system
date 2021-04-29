
package billingsystem;

import java.io.Serializable;

public class Stock implements Serializable {
    
    private String itemName,unitName; 
    private double initial_quantity; 
    private double available;
    private double quantity; 
    private String date; 

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
 
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getInitial_quantity() {
        return initial_quantity;
    }

    public void setInitial_quantity(double initial_quantity) {
        this.initial_quantity = initial_quantity;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

   
    
    
}
