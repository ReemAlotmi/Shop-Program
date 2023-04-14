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
public class AdministrationStaff extends Employee {
    private String position;

    public AdministrationStaff( String ID, String Name, String Address, String MobileNum, String Email, double Salary,String position) {
        super(ID, Name, Address, MobileNum, Email, Salary);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    

    @Override
    public String toString() {
        return "AdministrationStaff:\n"+super.toString() + ",   position: " + this.getPosition();
    }
    

    public static AdministrationStaff addEmployee(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the new AdministrationStaff Information: ");
                            System.out.print("1.ID Number: ");
                            String ID = scan.next();
                            System.out.print("2.Full Name: ");
                            String Name = scan.next();
                            System.out.print("3.Address: ");
                            String Address = scan.next();
                            System.out.print("4.Mobile Number: ");
                            String MobileNum = scan.next();
                            scan.nextLine();
                            System.out.print("5.Email: ");
                            String Email = scan.next();
                            System.out.print("6.Salary: ");
                            double Salary = scan.nextDouble();
                            System.out.print("7.Position:");
                            String Position = scan.next();
                            scan.nextLine();
        AdministrationStaff obj = new AdministrationStaff(ID, Name, Address, MobileNum, Email, Salary,Position);
        return obj;
    }
    
    
    
}
