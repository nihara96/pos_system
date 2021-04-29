
package billingsystem;

import java.io.Serializable;

public class Item implements Serializable {
    
   private String name; 
   private double cost; 
   private int itemCode; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

  
}
