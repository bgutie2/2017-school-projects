package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDDisplayMenu implements Command { //part of command design
    
    Aggregator agg;
    Menu menu;
    
    public CMDDisplayMenu(Aggregator agg) {
        this.agg = agg;
        this.menu = agg.getMenu();
    }
    
    @Override
    public String[] execute() {
        String[] descriptions = new String[menu.getSize()];
        int x = 0;
        
        while (x != menu.getSize()) {
            descriptions[x] = menu.getItem(x).descript();
            x++;
        }
        
        return descriptions;
        
        //return menu.generateDesc();
    }
    
}
