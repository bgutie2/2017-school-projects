package restaurant_program;

/**
 *
 * @author bruce
 */
public class CMDSubmitOrder implements Command { //part of command design
    
    Aggregator agg;
    Orders orders;
    OrderItem order;
    
    public CMDSubmitOrder(Aggregator agg, OrderItem order) {
        this.agg = agg;
        this.orders = agg.getOrders();
        this.order = order;
    }
    
    @Override
    public String execute() {
        orders.addOrder(order);
        return "Order added!";
    }
    
}
