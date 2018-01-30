package bestbuyreceipt_assign3;

/**
 *
 * @author makise-chan
 */
public class Coupon100Get10Percent implements AddOn, Coupon{
    
    public boolean applies(PurchasedItems items) {
        return items.getTotalCost() >= 100.00;
    }
    public String getLines() {
        return "Get 10 percent off any purchase for $100.00 or more.";
    }
    
}
