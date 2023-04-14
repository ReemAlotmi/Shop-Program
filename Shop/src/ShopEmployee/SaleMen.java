/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopEmployee;

import java.util.Scanner;

/**
 *
 * @author Reem Alotmi
 */
public class SaleMen extends Employee{
    String Rank;

    public SaleMen( String ID, String Name, String Address, String MobileNum, String Email, double Salary, String Rank) {
        super(ID, Name, Address, MobileNum, Email, Salary);
        this.Rank = Rank;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }
    
    

    @Override
    public String toString() {
        return "Sale Men:\n"+super.toString() + ",   Rank: " + this.getRank();
    }
    public static SaleMen addEmployee(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the new Sale Man Information :");
                            System.out.print("1.ID Number:");
                            String ID = scan.next();
                            System.out.print("2.Full Name ");
                            String Name = scan.next();
                            System.out.print("3.Address");
                            String Address = scan.next();
                            System.out.print("4.Mobile Number:");
                            String MobileNum = scan.next();
                            System.out.print("5.Email:");
                            String Email = scan.next();
                            System.out.print("6.Salary:");
                            double Salary = scan.nextDouble();
                            System.out.print("7.Rank:");
                            String Rank = scan.next();
                            SaleMen obj3 = new SaleMen(ID, Name, Address, MobileNum, Email, Salary, Rank);
        return obj3;
    }
    
    
}
