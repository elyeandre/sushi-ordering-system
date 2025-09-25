
package restaurantorderingandpayment;

public class Customer {
    
    private int cus_id;
    private String cus_username;
    private String cus_fullname;
    private String cus_phoneno;
    private String cus_address;
  
    

    public int getCustomerId() {
        return cus_id;
    }

    public void setCustomerId(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getCustomerUser() {
        return cus_username;
    }

    public void setCustomerUser(String cus_username) {
        this.cus_username = cus_username;
    }

    public String getCustomerName() {
        return cus_fullname;
    }

    public void setCustomerName(String cus_fullname) {
        this.cus_fullname = cus_fullname;
    }
    public String getCustomerPhone() {
        return cus_phoneno;
    }
    public void setCustomerPhone(String cus_phoneno) {
        this.cus_phoneno = cus_phoneno;
    }
    public String getCustomerAddr() {
        return cus_address;
       
    }
    public void setCustomerAddr(String cus_address) {
        this.cus_address = cus_address;
    }
 
}
