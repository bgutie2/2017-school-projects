package restaurant_program;

/**
 *
 * @author bruce
 */
public class Tab {
    
    private double subtotal, tax, tip, total;
    private String name;
    
    public Tab(String name, double subtotal) {
        this.name = name;
        this.subtotal = subtotal;
        tax = Math.round(subtotal * 0.06 * 100.00)/100.00;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTip() {
        return tip;
    }

    public double getTotal() {
        return total;
    }
    
    public String getName() {
        return name;
    }
    
    public void setTip(double tip) {
        this.tip = tip;
        total = subtotal+tax+tip;
    }
    
    @Override
    public String toString() {
        return String.format("Subtotal:         $"+subtotal+"\nTax:         "+tax);
    }
    
}
