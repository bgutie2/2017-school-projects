package bestbuyreceipt_assign3;
import java.util.*;
/**
 *
 * @author bruce
 */
public class PurchasedItems {
    
    private ArrayList<StoreItem> items;
    
    public PurchasedItems() {
        items = new ArrayList();
    }
    
    public void addItem(StoreItem item) {
        items.add(item);
    }
    
    public double getTotalCost() {
        
        double z = 0;
        
        for (int i = 0; i < items.size(); i++) {
            z += Double.parseDouble(items.get(i).getItemPrice());
        }
        
        return z;
    }
    
    public boolean containsItem(String itemCode) { 
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemCode().equals(itemCode))
                return true;
        }
        
        return false;
    }
    
    public void display() {
        String a;
        String b;
        String c;
        for (int i = 0; i < items.size(); i++) {
            a = items.get(i).getItemCode();
            b = items.get(i).getItemDescription();
            c = items.get(i).getItemPrice();
            System.out.format("%s %40s %15s \n", a, b, c);
        }
    }
    
}
