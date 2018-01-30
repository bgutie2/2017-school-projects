package bestbuyreceipt_assign3;

/**
 *
 * @author bruce
 */
public interface AddOn {
    public boolean applies(PurchasedItems items);
    public String getLines();
}
