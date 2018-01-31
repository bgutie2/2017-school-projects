package restaurant_program;

/**
 *
 * @author bruce
 */
public class Invoker { //part of command design
    
    private Aggregator agg;
    
    public Invoker(Aggregator agg) {
        this.agg = agg;
    }
    
    public String[] displayMenu() {
        return new CMDDisplayMenu(agg).execute();
    }
    
    public String submitOrder(OrderItem order) {
        return new CMDSubmitOrder(agg, order).execute();
    }
    
    public String[] displayTab(String name) {
        return new CMDDisplayTab(agg, name).execute();
    }
    
    public String[] displayDrinks() {
        return new CMDDisplayDrinks(agg).execute();
    }
    
    public String[] displaySides() {
        return new CMDDisplaySides(agg).execute();
    }
    
    public String[] displayEntrees() {
        return new CMDDisplayEntrees(agg).execute();
    }
    
    public String[] displayDesserts() {
        return new CMDDisplayDesserts(agg).execute();
    }
    
    public String[] checkout(int tab_index, double tip) {
        return new CMDCheckOut(agg, tab_index, tip).execute();
    }
    
    public String[] displayAllTabs() {
        return new CMDDisplayAllTabs(agg).execute();
    }
    
}
