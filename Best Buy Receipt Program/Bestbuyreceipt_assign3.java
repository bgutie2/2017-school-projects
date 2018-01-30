package bestbuyreceipt_assign3;
import java.io.*;
import java.util.*;
/*
 *
 * @author bruce
 */
public class Bestbuyreceipt_assign3 {

    public static void main(String[] args) throws FileNotFoundException {
        
        PurchasedItems items = new PurchasedItems();
        Receipt receipt = new BasicReceipt(items);
        int choice;
        String back;
        Date date = new Date(1, 1, 1999);
        populateList(items);
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please choose a date option: ");
        System.out.println("1 - Use current date");
        System.out.println("2 - Input your own date");
        
        switch(input.nextInt()) {
            case 1:
                date = new Date(Calendar.getInstance().get(Calendar.MONTH)+1, 
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.YEAR));
                break;
            case 2:
                System.out.println("Type in the month, day, and year in one line with spaces in between: ");
                int x = input.nextInt();
                int y = input.nextInt();
                int z = input.nextInt();
                date = new Date(x, y, z);
                break;
        }
        
        menu();
        choice = input.nextInt();
        inputloop: while(choice != 4) {
            switch(choice) {
                case 1:
                    receipt = build(items, date);
                    System.out.println("Receipt built!");
                    break;
                case 2:
                    add(items);
                    System.out.println("Added!");
                    break;
                case 3:
                    System.out.println();
                    receipt.prtReceipt();
                    break;
                case 4:
                    break;
            }
            
            System.out.print("Back to main menu? (Y/y ; N/n): ");
            back = input.next();
            System.out.println();
            if (back.equals("Y") || back.equals("y")) {
                menu();
                choice = input.nextInt();
            } else if (back.equals("N") || back.equals("n"))
                choice = 4;
        }
        
    }
    
    public static void populateList(PurchasedItems items) throws FileNotFoundException{
        Scanner list = new Scanner(new File("receipt_items.txt"));
        
        while (list.hasNextLine()) {
            StoreItem item = new StoreItem(list.nextLine(), list.nextLine(), list.nextLine());
            items.addItem(item);
        }
    }
    
    public static void menu() {
        System.out.println("1 - Build a new receipt");
        System.out.println("2 - Add items");
        System.out.println("3 - Display receipt");
        System.out.println("4 - Exit");
    }
    
    public static Receipt build(PurchasedItems items, Date date) throws FileNotFoundException {
        ReceiptFactory factory = new ReceiptFactory();
        Receipt receipt = factory.getReceipt(items, date);
        return receipt;
    }
    
    public static void add(PurchasedItems items) {
        String code;
        String desc;
        String price;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Type in the item code of the item: ");
        code = input.nextLine();
        
        System.out.println("Type in the name of the item: ");
        desc = input.nextLine();
        
        System.out.println("Type in the price of the item: ");
        price = input.nextLine();
        
        StoreItem item = new StoreItem(code, desc, price);
        items.addItem(item);
    }
}
