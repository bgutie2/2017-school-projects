package bestbuyreceipt_assign3;
/**
 *
 * @author bruce
 */
public class BasicReceipt implements Receipt {
    
    private String storeInfo; // store number, store address, phone number
    private String stateCode; // MD, DE, CA or MA
    private PurchasedItems items;
    private Date date;
    private TaxComputation tc;
    
    public BasicReceipt(PurchasedItems items) {
        this.items = items;
    }
    
    public void setTaxComputation(TaxComputation tc) { 
        this.tc = tc;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    
    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo;
    }
    
    public void prtReceipt() {
        System.out.println(storeInfo);
        System.out.println("                        "+date);
        System.out.println("\n");
        items.display();
        System.out.println();
    }
    
}
