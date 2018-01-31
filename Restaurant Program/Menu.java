package restaurant_program;
import java.util.*;
import java.io.*;
/**
 *
 * @author bruce
 */
public class Menu {
    
    private LinkedList<MenuItem> menu;
    public static final int DRINK = 0;
    public static final int SIDE = 1;
    public static final int ENTREE = 2; 
    public static final int DESSERT = 3;
    
    public Menu() throws FileNotFoundException{
        menu = new LinkedList();
        populate(); //populates when initialized
    }
    
    private void populate() throws FileNotFoundException { //populates menu linked list
        
        Scanner menu_file = new Scanner(new File("menu.txt"));
        String item;
        String name;
        String price;
        String type1;
        int type2;
        
        while (menu_file.hasNextLine()) {
            item = menu_file.nextLine();
            name = menu_file.nextLine();
            price = menu_file.nextLine();
            type1 = menu_file.nextLine();
            type2 = Integer.parseInt(type1);
            menu.add(new MenuItem(item, name, price, type2));
        }
        
        //check();
        
    }
    
    private void check() throws FileNotFoundException { //checks if the number of items in the text file is 
                                                        //the same as the number of items in the menu linkedlist
        Scanner valid = new Scanner(new File("valid.txt"));
        int num = valid.nextInt();
        
        if (num == menu.size()) 
            System.out.println("Menu populated!");
        else
            System.out.println("Error in populating menu!");
        
    }
    
    public String[] generateDesc() { //generates the string array if command cannot
        String[] descriptions = new String[menu.size()];
        int x = 0;
        
        while (menu.get(x) != null) {
            descriptions[x] = menu.get(x).descript();
            x++;
        }
        
        return descriptions;
        
    }
    
    public int getSize() { //returns size of list
        return menu.size();
    }
    
    public MenuItem getItem(int i) { //returns item through element
        return menu.get(i);
    }
    
    public MenuIterator getAllItemsIterator() {
        MenuIterator i1 = new AllItemsIterator(this, 0);
        return i1;
    }

    public MenuIterator getItemIterator(int item_type) {
        MenuIterator i2 = new ItemIterator(this, item_type);
        return i2;
    }
    
    private class AllItemsIterator implements MenuIterator {
        
        private Menu list;
        private int c_int;
        
        public AllItemsIterator(Menu menu, int start_loc) {
            list = menu;
            c_int = start_loc;
        }
        
        public boolean hasNext() {
            
            if (list.getItem(c_int) == null)
                return false;
            else
                return true;
            
        }

        public MenuItem nextItem() {
            
            MenuItem temp = list.getItem(c_int);
            c_int += 1;
            return temp;
            
        }

    }
    
    private class ItemIterator implements MenuIterator {
        
        private Menu list;
        private int item_type;
        private int c_index = 0;
        
        public ItemIterator(Menu menu, int type) {
            list = menu;
            item_type = type;
        }
        
        public boolean hasNext() {
            
            boolean result = false;
            int i = c_index;
            
            while (result == false && i < list.getSize()) {
                if (list.getItem(i).getItemType() == item_type)
                    result = true;
                i++;
            }
            
            return result;
        }

        public MenuItem nextItem() {
            
            MenuItem temp = new MenuItem("hi", "i", "am", 0);
            boolean found = false;
            
            while (found == false && hasNext() == true) {
                if (list.getItem(c_index).getItemType() == item_type) {
                    temp = list.getItem(c_index);
                    found = true;
                }
                c_index++;
            }
            
            return temp;
        }

    }
    
}
