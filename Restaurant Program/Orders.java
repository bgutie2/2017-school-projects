package restaurant_program;
import java.util.*;

/**
 *
 * @author bruce
 */
public class Orders {
    
    LinkedList<OrderItem> orders;
    
    public Orders() {
        orders = new LinkedList();
    }
    
    public void addOrder(OrderItem order) {
        orders.add(order);
    }
    
    public void removeOrder(String item_num) {
        
        boolean found = false;
        int i = 0;
        
        while (found == false) {
            if (orders.get(i).getItemNumber().equals(item_num)) {
                orders.remove(i);
                found = true;
            }
            i++;
        }
    }
    
    public int getSize() {
        return orders.size();
    }
    
    public String getOrderItemNumber(int i) {
        return orders.get(i).getItemNumber();
    }
    
}
