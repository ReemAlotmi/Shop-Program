/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopItems;
import java.util.ArrayList;
/**
 *
 * @author Reem Alotmi
 */
public class Items implements Comparable{
    private String Type;
    private int Number;
    private int AvailableNumber;
    private double price;
    ArrayList<Items> items= new ArrayList();


    public Items(String Type, int Number, double price) {
        this.Type = Type;
        this.Number = Number;
        this.AvailableNumber =20;
        this.price = price;
    }

    public Items() {
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getAvailableNumber() {
        return AvailableNumber;
    }

    public void setAvailableNumber(int AvailableNumber) {
        this.AvailableNumber = AvailableNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    // to compare items depending on type:
    @Override
    public int compareTo(Object o){
        return this.getType().compareTo(((Items)o).getType());
      }
    
    // to print all items in the shop :
    public static void printAllItems(ArrayList<Items> items){
        System.out.println("\t\t\t   *** Shop Items ***\n");
        for(Items c: items) System.out.printf("Item: %-25s Number: %-20d Price: %.2f\n", c.getType(),c.getNumber(),c.getPrice());
        System.out.println("");
    }
    
    // static method that returns an object of type depending on the ID
    public static Items findItemsId(int numberItem, ArrayList<Items> items){
        int i=0;
        for(; i<items.size(); i++){
            if(numberItem==items.get(i).getNumber())
                break;
    }  return items.get(i);
    }
    
   
    
     @Override
     public String toString() {
         return  String.format("Furniture:          Type: %-17s ,Number: %-5d ,AvailableNumber: %-5d ,price: %-10.2f",this.getType(),this.getNumber(),this.getAvailableNumber(),this.getPrice());
    }
    
}
