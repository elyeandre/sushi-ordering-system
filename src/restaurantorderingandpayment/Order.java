/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantorderingandpayment;


import java.text.DecimalFormat;

public class Order {
 

    private int id;
    private String item;
    private int quanity;
    public double unitPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getUnitPrice() {
        return unitPrice;
       
    }
       

    public void setUnitPrice(double unitPrice) {
      
       this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return getUnitPrice() * getQuanity();
        
    } 
    
}
class DecimalFormatter extends Order {
    DecimalFormat df = new DecimalFormat("0.00");
    
   public double Decimal(double value)  {
         value = Double.valueOf(df.format(unitPrice));
         return value;
   }
 
}