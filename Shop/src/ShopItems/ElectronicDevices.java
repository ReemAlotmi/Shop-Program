/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopItems;

/**
 *
 * @author Reem Alotmi
 */

public class ElectronicDevices extends Items{
   private int Warranty;
    
    public ElectronicDevices(String Type, int Number,  double price,int Warranty) {
        super(Type, Number,  price);
        this.Warranty = Warranty;
    }

    public ElectronicDevices() {
    }

    public int getWarranty() {
        return Warranty;
    }

    public void setWarranty(int Warranty) {
        this.Warranty = Warranty;
    }

    @Override
    public String toString() {
        return String.format("ElectronicDevices:  Type: %-17s ,Number: %-5d ,AvailableNumber: %-5d ,price: %-10.2f ,warranty: %d years",this.getType(),this.getNumber(),this.getAvailableNumber(),this.getPrice(),this.getWarranty());
    }
    
}
