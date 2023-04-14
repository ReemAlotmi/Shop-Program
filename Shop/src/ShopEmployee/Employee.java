/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShopEmployee;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Reem Alotmi
 */
public class Employee {
    private String ID;
    private String Name;
    private String Address;
    private String MobileNum;
    private String Email;
    private double Salary;
    private ArrayList<Employee> e= new ArrayList();
    
    public Employee(){}

    public Employee(String ID, String Name, String Address, String MobileNum, String Email, double Salary) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.MobileNum = MobileNum;
        this.Email = Email;
        this.Salary = Salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getMobileNum() {
        return MobileNum;
    }

    public void setMobileNum(String MobileNum) {
        this.MobileNum = MobileNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return  "ID: " + this.getID() + ",  Name: " + this.getName() + ",   Address: " + this.getAddress() + ",   MobileNum: " + this.getMobileNum() + ",   Email: " + this.getEmail() + ",   Salary: " + this.getSalary();
    }
    
    /*public static Employee addEmployee(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the new Employee Information: ");
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
        Employee obj = new Employee(ID, Name, Address, MobileNum, Email, Salary);
        return obj;
    }*/
    
}
