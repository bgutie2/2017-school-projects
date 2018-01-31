package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDDisplayTab implements Command { //part of command design
    
    private Aggregator agg;
    private Menu menu;
    private Orders orders;
    private Tabs tabs;
    private String name;
    
    public CMDDisplayTab(Aggregator agg, String name) {
        this.agg = agg;
        this.menu = agg.getMenu();
        this.orders = agg.getOrders();
        this.tabs = agg.getTabs();
        this.name = name;
    }
    
    @Override
    public String[] execute() {
        String[] reciept = new String[orders.getSize()+2];
        reciept[0] = "This is your tab.";
        int x = 1;
        double subtotal = 0;
        
        for (int i = 0; i < orders.getSize(); i++) {
            boolean found = false;
            int y = 0;
            while (found == false) {
                MenuItem temp = menu.getItem(y);
                if (orders.getOrderItemNumber(i).equals(temp.getItemNumber())) {
                    reciept[x] = temp.descript();
                    subtotal += Double.parseDouble(temp.getPrice());
                    found = true;
                    x++;
                } //end of if statement
                y++;
            } //end of while loop
        } //end of for loop
        
        tabs.addTab(new Tab(name, subtotal));
        reciept[x] = String.format("%-32s $%s","Subtotal:",subtotal);
        
        return reciept;
    }
    
}
