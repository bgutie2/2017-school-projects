package bestbuyreceipt_assign3;
import java.io.*;
import java.util.*;
/**
 *
 * @author bruce
 */
public class ReceiptFactory {
    
    String header; // contains line with “Best Buy”, store_num, street_addr, phone
    String state_code;
    private TaxComputation tax;
    private TaxComputation[] taxComputationsObjs; // tax computation objects (for each state)
    private AddOn[] addOns; // secondary heading, rebate and coupon add-ons
    
    public ReceiptFactory() throws FileNotFoundException { // constructor
        // 1. Populates array of StateComputation objects and array of AddOn objects (as if downloaded
        //    from the BestBuy web site).
        
        taxComputationsObjs = new TaxComputation[3];
        taxComputationsObjs[0] = new MDTaxComputation();
        //taxComputationsObjs[1] = new CATaxComputation();
        //taxComputationsObjs[2] = new MATaxComputation();
        addOns = new AddOn[3];
        addOns[0] = new Rebate1406();
        addOns[1] = new HolidayGreeting();
        addOns[2] = new Coupon100Get10Percent();
        
        // 2. Reads config file to assign store_num, street_addr, etc.
        
        Scanner config = new Scanner(new File("receipt_config.txt"));
        header = config.nextLine();
        state_code = config.nextLine();
        
        // 3. Based on the state code (e.g., “MD”, from the config file) stores appropriate
        //    StateComputation object to be used on all receipts.
        
        if (state_code.equals("MD"))
            tax = taxComputationsObjs[0];
        else if (state_code.equals("CA"))
            tax = taxComputationsObjs[1];
        else if (state_code.equals("MA"))
            tax = taxComputationsObjs[2];
    }
    public Receipt getReceipt(PurchasedItems items, Date date) {
        
        Receipt rec1;
        BasicReceipt rec2 = new BasicReceipt(items);
        // 1. Sets the current date of the BasicReceipt.
        
        rec2.setDate(date);
        rec2.setTaxComputation(tax);
        rec2.setStateCode(state_code);
        rec2.setStoreInfo(header);
        
        // 3. Traverses over all AddOn objects, calling the applies method of each. If an AddOn object applies, 
        //    then determines if the AddOn is of type SecondaryHeader, Rebate, or Coupon.
        //    If of type SecondaryHeader, then creates a PreDecorator for the AddOn. If of type Rebate or
        //    Coupon, then creates a PostDecorator.
        
        rec1 = rec2;
        
        for (int i = 0; i < 3; i++) {
            
            if (addOns[i].applies(items)) {
                
                if (addOns[i] instanceof SecondaryHeading) 
                    rec1 = new PreDecorator(addOns[i], rec1);
                
                if (addOns[i] instanceof Rebate ||addOns[i] instanceof Coupon)
                    rec1 = new PostDecorator(addOns[i], rec1);
            }
            
        }
        
        // 4. Links in the decorator object based on the Decorator design pattern.
        // 5. Adds current date to
        // 6. Returns decorated BasicReceipt object as type Receipt.
        return rec1;
    }
    
}
