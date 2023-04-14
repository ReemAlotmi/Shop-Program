/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerBilling;

import ShopItems.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author Reem Alotmi
 */
public class Bill implements BillInterface {

    private int billNum;
    private ArrayList<Items> purchase = new ArrayList();

    /**
     * constructor that take the purchased item for certain customer and
     * generate the bill for this customer
     *
     * @param Purchase
     */

    public Bill(ArrayList<Items> purchase, int billNum) {
        this.billNum = billNum;
        this.purchase = purchase;
    }

    public Bill() {

    }

    public int getBillNum() {
        return billNum;
    }

    public void setBillNum(int billNum) {
        this.billNum = billNum;
    }

    public ArrayList<Items> getPurchase() {
        return purchase;
    }

    public void setPurchase(ArrayList<Items> purchase) {
        this.purchase = purchase;
    }

    @Override
    public String toString() {
        return "Bill Number:" + this.getBillNum() + "\nPurchases:" + this.getPurchase();
    }

    /**
     * method to print the bill number and calculate the total price for
     * customer + decrease the available number of the purchased items
     *
     * @param
     *
     */

    @Override
    public void printBill() {
        System.out.println("\nBill Number: " + this.getBillNum());
        double total = 0;
        int i = 0;
        Iterator list = this.getPurchase().iterator();
        for (i = 0; i < this.getPurchase().size();) {
            int f = (this.getPurchase().get(i).getAvailableNumber()) - 1;
            this.getPurchase().get(i).setAvailableNumber(f);
            total += this.getPurchase().get(i).getPrice();
            i++;
        }
        System.out.printf("The total price is: %.2f \n\n" , total);
    }
    
    @Override
    public void printAllBill() {
        System.out.print("Bill number: " + this.getBillNum() + " Purchases:");  //will print the bill numbers and the purchased items' type        
        // System.out.println(bill.get(j).toString());
        for (int t = 0; t < this.getPurchase().size(); t++) 
        System.out.print("  " + this.getPurchase().get(t).getType()); //to print only the items namein this bill
        System.out.println(" ");
    }

    

}
