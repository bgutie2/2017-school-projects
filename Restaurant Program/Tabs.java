package restaurant_program;
import java.util.*;
/**
 *
 * @author bruce
 */
public class Tabs {
    
    private LinkedList<Tab> tabs;
    
    public Tabs() {
        tabs = new LinkedList();
    }
    
    public void addTab(Tab tab) {
        tabs.add(tab);
    }
    
    public Tab getTab(int index) {
        return tabs.get(index);
    }
    
    public int getSize() {
        return tabs.size();
    }
    
}
