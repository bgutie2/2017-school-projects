package restaurant_program;
import java.util.*;
import java.io.*;

public class Restaurant_Program {

    public static void main(String[] args) throws FileNotFoundException {
        
        System_Interface.initialize();
        Scanner input = new Scanner(System.in);
        int select = 0;
        boolean tab_displayed = false;
        
        while(select != 5) {
            if (tab_displayed == false) { //checks if the tab was displayed in order to display updated menu
                mainMenu();
                select = input.nextInt();
                System.out.println();
                if (select == 4)
                    select = 5;
            } else {
                mainMenu2();
                select = input.nextInt();
            }
            switch(select) {
                case 1: //display menu
                    menuOptions();
                    break;
                case 2: //order an item
                    System.out.println("What would you like to order?");
                    String order_number = input.next();
                    System_Interface.addOrderItem(order_number);
                    System.out.println("\n"); //formatting
                    break;
                case 3: //display tab
                    System.out.println("Who is this tab for?");
                    System.out.print("Enter first name: ");
                    String name = input.next();
                    System_Interface.displayTab(name);
                    System.out.println("\n"); //formatting
                    tab_displayed = true; //tab was displayed
                    tabDisplayed(tab_displayed, select, input);
                    break;
                case 4: //check out
                    checkout();
                    break;
                case 5: //exit
                    System.out.println("Thank you! Come again!");
                    break;
            }
            
        }
    }
    
    public static void mainMenu() { //start-up menu
        System.out.println("1 - Display Menu");
        System.out.println("2 - Order Item");
        System.out.println("3 - Display Tab");
        System.out.println("4 - Exit");
    }
    
    public static void mainMenu2() { //displays this menu after display tab
        System.out.println("1 - Display Menu");
        System.out.println("2 - Order Item");
        System.out.println("3 - Display Tab");
        System.out.println("4 - Check Out");
        System.out.println("5 - Exit");
    }
    
    public static void checkout() { //check-out function
        Scanner input = new Scanner(System.in);
        int select;
        double tip;
        System.out.print("Please select a tab: ");
        System_Interface.displayAllTabs();
        select = input.nextInt();
        System.out.println("\nHow much would you like to tip?");
        tip = input.nextDouble();
        System_Interface.checkout(select-1, tip);
    }
    
    public static void tabDisplayed(Boolean tab_displayed, int select, Scanner input) { //checks if the tab was displayed in order to give option of checking out
        if (tab_displayed == true && select != 5) {
            System.out.println("Would you like to check out? (yes/no)");
            String answer = input.next();
            if (answer.equals("yes"))
                checkout();
            else
                System.out.println("Okay! Let me know when you would like to check out!\n");
        }
    }
    
    public static void menuOptions() { //displays the different menu options
        Scanner input = new Scanner(System.in);
        System.out.println("1 - Display entire menu \n2 - Display drinks \n3 - Display sides");
        System.out.println("4 - Display entrees \n5 - Display desserts");
        int opt = input.nextInt();
        System.out.println();
        switch(opt) {
                case 1: //display entire menu
                    System.out.println("Please write down the entire item number of what you would like!");
                    System.out.println("Menu\n--------");
                    System.out.printf("%-10s %-25s  %s \n", "Item #", "Item Name", "Price");
                    System.out.println("-------------------------------------------");
                    System_Interface.displayMenu();
                    System.out.println(); //formatting
                    break;
                case 2: //display drinks
                    System.out.println("Please write down the entire item number of what you would like!");
                    System.out.println("Drinks\n--------");
                    System.out.printf("%-10s %-25s  %s \n", "Item #", "Item Name", "Price");
                    System.out.println("-------------------------------------------");
                    System_Interface.displayDrinks();
                    System.out.println(); //formatting
                    break;
                case 3: //display sides
                    System.out.println("Please write down the entire item number of what you would like!");
                    System.out.println("Sides\n--------");
                    System.out.printf("%-10s %-25s  %s \n", "Item #", "Item Name", "Price");
                    System.out.println("-------------------------------------------");
                    System_Interface.displaySides();
                    System.out.println(); //formatting
                    break;
                case 4: //display entrees
                    System.out.println("Please write down the entire item number of what you would like!");
                    System.out.println("Entrees\n--------");
                    System.out.printf("%-10s %-25s  %s \n", "Item #", "Item Name", "Price");
                    System.out.println("-------------------------------------------");
                    System_Interface.displayEntrees();
                    System.out.println(); //formatting
                    break;
                case 5: //display desserts
                    System.out.println("Please write down the entire item number of what you would like!");
                    System.out.println("Desserts\n--------");
                    System.out.printf("%-10s %-25s  %s \n", "Item #", "Item Name", "Price");
                    System.out.println("----------------------------------------");
                    System_Interface.displayDesserts();
                    System.out.println(); //formatting
                    break;
                case 6: //exit
                    break;
            }
    }
    
}
