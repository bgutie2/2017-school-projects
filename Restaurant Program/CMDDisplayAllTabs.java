package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDDisplayAllTabs implements Command {
    
    private Aggregator agg;
    private Tabs tabs;
    
    public CMDDisplayAllTabs(Aggregator agg) {
        this.agg = agg;
        tabs = agg.getTabs();
    }
    
    @Override
    public String[] execute() {
        String[] all_tabs = new String[tabs.getSize()];
        for (int i = 0; i < tabs.getSize(); i++) {
            all_tabs[i] = (i+1)+" - "+tabs.getTab(i).getName();
        }
        return all_tabs;
    }
    
}
