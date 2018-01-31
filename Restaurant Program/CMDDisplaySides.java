package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDDisplaySides implements Command {
    
    Aggregator agg;
    Menu menu;
    
    public CMDDisplaySides(Aggregator agg) {
        this.agg = agg;
        menu = agg.getMenu();
    }
    
    @Override
    public String[] execute() {
        MenuItem item;
        int i = 0;
        String[] drinks = new String[menu.getSize()];
        MenuIterator itr = menu.getItemIterator(Menu.SIDE);
        
        while (itr.hasNext()) { 
            item = itr.nextItem();
            drinks[i] = item.descript();
            i++;
        }
        
        return drinks;
    }
    
}
