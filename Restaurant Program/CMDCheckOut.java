package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDCheckOut implements Command { //part of command design
    
    private Aggregator agg;
    private Tabs tabs;
    private Tab tab;
    private double tip;
    
    public CMDCheckOut(Aggregator agg, int tab_index, double tip) {
        this.agg = agg;
        tabs = agg.getTabs();
        tab = tabs.getTab(tab_index);
        this.tip = tip;
    }
    
    @Override
    public String[] execute() {
        String[] receipt = new String[6];
        tab.setTip(tip);
        receipt[0] = "Name: "+tab.getName();
        receipt[1] = "Subtotal:         $"+tab.getSubtotal();
        receipt[2] = "Tip:              $"+tab.getTip();
        receipt[3] = "Tax:              $"+tab.getTax();
        receipt[4] = "Total:            $"+tab.getTotal();
        receipt[5] = "Thanks for coming!";
        return receipt;
    }
    
}
