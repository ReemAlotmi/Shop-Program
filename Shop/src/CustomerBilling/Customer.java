/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerBilling;
import java.util.*;
import ShopItems.Items;

/**
 *
 * @author Reem Alotmi
 */
public class Customer {
    private String ID;
    private String name;
    private String mobile;
    private int billNumber;
/**
 * constructor
 * @param ID
 * @param name
 * @param mobile
 * @param billNumber 
 */
    public Customer(String ID, String name, String mobile, int billNumber) {
        this.ID = ID;
        this.name = name;
        this.mobile = mobile;
        this.billNumber = billNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    
    
    
    @Override
    public String toString() {
        return "Customer:\n" + "ID: " + this.getID() + ", name: " + this.getName() + ", mobile: " + this.getMobile() + ", Bill Number: " + this.getBillNumber();
    }

    

    @Override
    public boolean equals(Object obj) {
        Customer c=(Customer) obj;
        if(this.getID()==c.getID())
        return true;
        else return false;
    }
    
    
    
    
}

