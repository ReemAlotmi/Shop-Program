/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerBilling;

import java.util.ArrayList;
import ShopItems.*;
import ShopEmployee.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Reem Alotmi
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);

        //ArrayListss
        ArrayList<Items> customerPurchase = new ArrayList();
        ArrayList<Items> items = new ArrayList();
        ArrayList<Employee> Administration = new ArrayList();
        ArrayList<Customer> Cst = new ArrayList();
        ArrayList<Bill> bill = new ArrayList();

        // All Items available in the Shop
        Items DishWasher = new ElectronicDevices("Dish Washer", 43, 2999, 5);
        Items CoffeeMachine = new ElectronicDevices("Coffee Machine", 32, 1199, 3);
        Items IpadPro = new ElectronicDevices("Ipad Pro", 01, 3999, 2);
        Items Printer = new ElectronicDevices("Printer", 10, 449, 2);
        Items LabTop = new ElectronicDevices("Lab Top", 69, 4599, 2);
        Items Disk = new Items("Disk", 11, 499);
        Items Dresser = new Items("Dresser", 78, 999);
        Items SideTable = new Items("Side Table", 07, 249);
        Items Sofa = new Items("Sofa", 12, 1499);
        Items Shelf = new Items("Shelf", 30, 99);

        items.add(DishWasher);
        items.add(CoffeeMachine);
        items.add(IpadPro);
        items.add(Printer);
        items.add(LabTop);
        items.add(Disk);
        items.add(Dresser);
        items.add(SideTable);
        items.add(Sofa);
        items.add(Shelf);
        Collections.sort(items); //To sort all Items by their number
        //Items.printAllItems(items); //Method to Print all the Items in the Shop with Their number/ID and price

        try {
            File file = new File("AddStaffINFO.txt");
            Scanner inputFile = new Scanner(file);
            while (inputFile.hasNext()) {
                String id = inputFile.nextLine();//id
                String Name = inputFile.nextLine();// name
                String Address = inputFile.nextLine();// address
                String MobileNum = inputFile.nextLine();// moblie number
                String Email = inputFile.nextLine();// email
                double Salary = inputFile.nextDouble(); //salary
                inputFile.nextLine();
                String Position = inputFile.nextLine(); //position
                AdministrationStaff obj1 = new AdministrationStaff(id, Name, Address, MobileNum, Email, Salary, Position);
                Administration.add(obj1);
                //System.out.println(id+"\n"+Name+"\n"+Address+"\n"+MobileNum+"\n"+Email+"\n"+Salary+"\n"+Position);
                //System.out.println(" ");
            }
            inputFile.close();
        } catch (IOException ex) {
        }

        for (Employee c : Administration) {
            System.out.println(c + "\n");
        }

        System.out.println("Entering the System...");
        //Ask the Employee to enter his/her name to show the selection screen
        boolean b = true;
        do {
            System.out.println("Enter your Name: ");
            String Name = scan.nextLine();

            String n = null;
            int i;

            for (i = 0; i < Administration.size(); i++) {
                n = Administration.get(i).getName();
                if (!(Name.equals(n))) { //if names are equal convert to false to go to else which will break the for loop
                    continue;
                } else {
                    break; //to exit for loop
                }
            }
            if (!(Name.equals(n))) { //if input(name) is not in the Administration Staff
                continue;
            } else { //move to id input
                System.out.println("Enter your ID: "); //Ask fo her/his ID
                String ID = scan.nextLine();
                String id = Administration.get(i).getID();
                if (ID.equals(id)) {
                    b = false; //to exit the while and move to the selection screen
                } else {
                    System.out.println("Wrong ID for Employee " + Administration.get(i).getName());
                }
            }
        } while (b);
        
        

        //Selection Screen
        System.out.println("Entering the Selection Screen... ");
        int choice;
        int c;
        do {
            System.out.println("\n1. Staff Selection Screen\n2. Items Selection Screen\n3. Bill Selection Screen\n4. Exit Program");
            System.out.println("Enter your choice:");
            choice = scan.nextInt();
            System.out.println("");
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //selection 1. Staff Selection Screen
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
            if (choice == 1) {

                System.out.println("Enter your choice\n1.Add new Employee\n2.Print Employee Informations\n3.Back to the main Screen");
                int Choice = scan.nextInt();
                do {
                    if (Choice == 1) { //1.Add new Employee
                        System.out.println("To add a new Employee, please choose his type:\n1.AdministrationStaff\n2.Sale Men");
                        int op = scan.nextInt();
                        if (op == 1) {  //1.AdministrationStaff
                            AdministrationStaff obj2 = AdministrationStaff.addEmployee(); //static method to read new employee info
                            Administration.add(obj2);
                            System.out.println("\n" + obj2.toString() + "\n");

                        } else if (op == 2) { //2. Sale Men
                            SaleMen obj3 = SaleMen.addEmployee();
                            Administration.add(obj3);
                            System.out.println("\n" + obj3.toString() + "\n");

                        } else {
                            System.out.println("Invalid input! Try Again");
                        }

                    } else if (Choice == 2) { //2.Print Employee Informations

                        System.out.print("To print Employee Informations, Enter Employee ID: ");
                        String id = scan.next();
                        for (int i = 0; i < Administration.size(); i++) {
                            String f = Administration.get(i).getID();
                            if (id.equals(f)) {
                                System.out.println("" + Administration.get(i).toString() + "\n");
                            }
                        }
                    } else if (Choice == 3) {//3. Back to the main Screen
                        System.out.println("Back to the main screen...");
                        continue;
                    } else {
                        System.out.println("Invalid input! Try Again");
                    }

                    System.out.print("1.Add new Employee\n2.Print Employee Informations\n3.Back to the main Screen\nEnter your choice: ");
                    Choice = scan.nextInt();
                } while (Choice != 3);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                //selection 2. Items Selection Screen
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                
            } else if (choice == 2) {
                int select = 0;
                do {
                    System.out.println("1. add items\n2. print the items depending on the number \n3. print all items depending on the type\n4. Exit to back screen\nEnter your choice:");
                    select = scan.nextInt();
                    // declaration for all variable:
                    Items item = null;
                    int add = 0;
                    ElectronicDevices ElectronicDevices = null;
                    switch (select) {

                        /*in first case: add items in this case we ask the user if he want increase the quantity to
            items already existing in the list or to add new item */
                        case 1:
                            System.out.println("If you want to add an existing item put 1, if you want to add a new item put 2");
                            add = scan.nextInt();

                            /*if the user want to add quantity to item already existing i need to Ask the user how much he 
            want to add  it and i will increase the AvailableNumber*/
                            if (add == 1) {
                                System.out.println("Enter the number(ID) of the item: ");
                                int num = scan.nextInt();
                                System.out.println("Enter the amount you want to add:");
                                int available = scan.nextInt();
                                int ii1 = Items.findItemsId(num, items).getAvailableNumber();
                                Items.findItemsId(num, items).setAvailableNumber(ii1 + available);
                                System.out.println(Items.findItemsId(num, items).toString());
                                System.out.println("");
                            } /*if the user want to add new item i need to create new object and add it to
           ArrayList And add all the information related to this object */ else if (add == 2) {
                                System.out.println("\nPlease enter the item information in this format(Type, Number, price, warranty)");
                                System.out.println("Enter the type of the item: ");
                                scan.nextLine();
                                String type = scan.nextLine();
                                int num = 0;
                                boolean checkNum = true, matches = true;
                                System.out.println("Enter the number for the item: ");
                                while (checkNum) {
                                    matches = true;
                                    num = scan.nextInt();
                                    for (int i = 0; i < items.size(); ++i) {
                                        if (num != items.get(i).getNumber()) {
                                            matches = true;
                                            continue;
                                        } else {
                                            System.out.println("There is already an item with this number!, Please enter another number: ");
                                            matches = false;
                                            break;
                                        }
                                    }
                                    if (matches == true) {
                                        break;
                                    }
                                }
                                scan.nextLine();
                                System.out.println("Enter the item price: ");
                                double itemsPrices = scan.nextDouble();
                                System.out.println("\nEnter the warranty of the item: \n*Note: if the item doesn't have warranty put 0");
                                int warranty = scan.nextInt();

                                // if the (warranty==0) i will call the constructer Items class 
                                if (warranty == 0) {
                                    item = new Items(type, num, itemsPrices);
                                    items.add(item);
                                    System.out.println(item);
                                    System.out.println("");
                                } // else i will constructer ElectronicDevices class
                                else {
                                    ElectronicDevices = new ElectronicDevices(type, num, itemsPrices, warranty);
                                    items.add(ElectronicDevices);
                                    System.out.println(ElectronicDevices);
                                    System.out.println("");
                                }
                            } else {
                                System.out.println("Invalid choice!");
                            }
                            break;

                        /* in second case: i will print the information about the item depending the ID, if the user enter 
           number not exist in shop i will ask him to enter the another number/ID that exist in the shop */
                        case 2:
                            int numberItem;
                            System.out.println("\n*print the item information depending on the number* ");
                            boolean checkID = true;
                            while (checkID) {
                                checkID = false;
                                try {
                                    System.out.println("Enter the number of the item you want it: ");
                                    numberItem = scan.nextInt();
                                    System.out.println(Items.findItemsId(numberItem, items));
                                } catch (Exception e) {
                                    checkID = true;
                                }
                            }
                            System.out.println("");
                            break;

                        // in third case: i will sort  all items the list depending the alphabet and print it
                        case 3:
                            Collections.sort(items);
                            System.out.println("");
                            System.out.println("Department                 Type           Number     AvailableNumber       price       Warranty\n");
                            for (int i = 0; i < items.size(); ++i) {
                                if(items.get(i) instanceof ElectronicDevices){
                                    System.out.printf("ElectronicDevices:    %-17s     %-5d           %-5d         %-10.2f   %d years\n", items.get(i).getType(), items.get(i).getNumber(), items.get(i).getAvailableNumber(), items.get(i).getPrice(),((ElectronicDevices)items.get(i)).getWarranty());
                                
                            }
                                else{
                                    System.out.printf("Furniture:            %-17s     %-5d           %-5d         %-10.2f\n", items.get(i).getType(), items.get(i).getNumber(), items.get(i).getAvailableNumber(), items.get(i).getPrice());  
                                }
                                
                            }
                            System.out.println("");
                            break;

                        // in fourth case: the user will back to the main Screen
                        case 4:
                            continue;
                        default:
                            System.out.println("Invalid choice");
                            break;

                    }
                } while (select != 4);

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                                        //selection 3. Bill Selection Screen            
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                
            } else if (choice == 3) {

                do {
                    System.out.println("1. Add new Customer \n2. Print the Bill \n3. Print all bill for a customer \n4. Back to the main Screen");
                    System.out.println("Enter your choice:");
                    c = scan.nextInt();
                    scan.nextLine();
                    if (c == 1) { ////add new customer////
                        customerPurchase = new ArrayList();
                        System.out.println("Choose:\n1.To add items to List.\n2.Proceed for billing.");
                        int chose = scan.nextInt();

                        do {
                            if (chose == 1) { //adding items to list
                                Items.printAllItems(items);
                                boolean isavailable=true;
                                System.out.println("Enter items by number:");
                                int itms = scan.nextInt();
                                for (int i = 0; i < items.size(); i++) {
                                    
                                    if (itms == items.get(i).getNumber()) {
                                        customerPurchase.add(items.get(i));
                                        isavailable=true;
                                        break;
                                    }
                                    else isavailable=false;
                                }
                                if(isavailable ==true) System.out.println("\nAdding item to list...\n");
                                else System.out.println("Unavailable item's number! try again\n");
                                
                            } else if (chose == 2) //billing
                            {
                                System.out.println("Billing...\n");
                        
                            } else {
                                System.out.println("Invalid input!");
                            }

                            System.out.println("Choose:\n1.to add more items to List.\n2.proceed for billing.");
                            chose = scan.nextInt();
                        } while (chose != 2); //end of while loop when chose 2 (proceed for billing)
                        
                        //input informaition to create Bill and Customer objects
                        System.out.println("Enter the Bill number:");
                        int bi = scan.nextInt();
                        System.out.println("Enter the ID: ");
                        scan.nextLine();
                        String ID = scan.nextLine();
                        System.out.println("Enter the name: ");
                        String Name = scan.nextLine();
                        System.out.println("Enter the mobile number: ");
                        String MB = scan.next();
                        
                        Bill generateBill = new Bill(customerPurchase, bi); //create bill object contains customer's item list and bill number
                        bill.add(generateBill);
                        
                        //Customer cst = new Customer(ID, Name, MB, generateBill.getBillNum()); //create new customer with bill number
                        Customer cst = new Customer(ID, Name, MB, generateBill.getBillNum());
                        Cst.add(cst);
                        
                        System.out.println("New Customer Added successfully\n ");
                        System.out.println(cst.toString());
                        System.out.println("");

                    } else if (c == 2) {////print the bill by providing the bill number////
                        System.out.println("Enter the Bill number: ");
                        int blnum = scan.nextInt();
                        boolean billavail=true;
                        for (int i = 0; i < bill.size(); i++) {
                            if (blnum == bill.get(i).getBillNum()) {
                                bill.get(i).printBill(); //printBill() is a method in the Bill clase that calculate the total price and decrease the available number 
                                billavail=true; break;
                            }
                            else billavail=false;
                        }
                        if(billavail==false) System.out.println("Bill number not found!\n");
                        
                    } else if (c == 3) {////print all bills for a customer////
                        System.out.println("Enter the customer id:");
                        String dd = scan.nextLine();
                        
                        for (int i = 0; i < Cst.size(); i++) {
                            if (dd.equals(Cst.get(i).getID())) {  //comparing the input id with all ids in Cst Arraylist
                                int bl = Cst.get(i).getBillNumber();
                                for (int j = 0; j < bill.size(); j++) {
                                    int bl2 = bill.get(j).getBillNum();
                                    if (bl == bl2) { //if this Cst bill number matches a bill number in the bill ArrayList
                                        bill.get(j).printAllBill(); //print bill number and items of this bill
                                    }
                                }
                            }
                        }
                    } else if (c == 4) {
                        System.out.println("");
                        System.out.println("Back to the main Screen...");
                    } else {
                        System.out.println("Invalid input! Try Again");
                    }
                } while (c != 4);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                

                //selection 4.Exit program
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            } else if (choice == 4) {
                System.out.println("Logging out...");
            } else {
                System.out.println("Invalid input!");
            }

        } while (choice != 4);

        //End of the ptogram...

    }

}
