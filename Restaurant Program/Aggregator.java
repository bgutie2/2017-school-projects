package restaurant_program;
import java.io.*;
/**
 *
 * @author bruce
 */
public class Aggregator { //holds all of the collections
    
    private Menu menu;
    private Orders orders;
    private Tabs tabs;
    
    public Aggregator() throws FileNotFoundException{
        menu = new Menu();
        orders = new Orders();
        tabs = new Tabs();
    }

    public Menu getMenu() {
        return menu;
    }

    public Orders getOrders() {
        return orders;
    }
    
    public Tabs getTabs() {
        return tabs;
    }
    
}
