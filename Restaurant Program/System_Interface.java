package restaurant_program;
import java.io.*;
/**
 *
 * @author bruce
 */
public class System_Interface {
    
    private static Invoker invoker;
    
    public static void initialize() throws FileNotFoundException{
        invoker = new Invoker(new Aggregator());
    }
    
    public static void addMenuItem() {
        
    }
    
    public static void addOrderItem(String item_number) {
        System.out.println(invoker.submitOrder(new OrderItem(item_number)));
    }
    
    public static void displayMenu() {
        String[] desc = invoker.displayMenu();
        for (int i = 0; i < desc.length; i++) {
            System.out.println(desc[i]);
        }
        
    }
    
    
    public static void displayTab(String name) {
        String[] tab = invoker.displayTab(name);
        for (int i = 0; i < tab.length; i++) 
            System.out.println(tab[i]);
    }
    
    public static void displayAllTabs() {
        String[] tabs = invoker.displayAllTabs();
        for (int i = 0; i < tabs.length; i++)
            System.out.println(tabs[i]);
    }
    
    public static void displayDrinks() {
        String[] drinks = invoker.displayDrinks();
        int i = 0;
        while (drinks[i] != null) {
            System.out.println(drinks[i]);
            i++;
        }
    }
    
    public static void displaySides() {
        String[] sides = invoker.displaySides();
        int i = 0;
        while (sides[i] != null) {
            System.out.println(sides[i]);
            i++;
        }
    }
    
    public static void displayEntrees() {
        String[] entrees = invoker.displayEntrees();
        int i = 0;
        while (entrees[i] != null) {
            System.out.println(entrees[i]);
            i++;
        }
    }
    
    public static void displayDesserts() {
        String[] desserts = invoker.displayDesserts();
        int i = 0;
        while (desserts[i] != null) {
            System.out.println(desserts[i]);
            i++;
        }
    }
    
    public static void checkout(int tab_index, double tip) {
        String[] receipt = invoker.checkout(tab_index, tip);
        for (int i = 0; i < 6; i++)
            System.out.println(receipt[i]);
    }
    
}
