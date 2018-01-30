package bestbuyreceipt_assign3;
/**
 *
 * @author bruce
 */
public class MDTaxComputation extends TaxComputation {
    
    public double computeTax(PurchasedItems items, Date date) {
        
        if (taxHoliday(date))
            return 0;
        else
            return 0.06;
        
        // calls private method taxHoliday as part of this computation
    }
    protected boolean taxHoliday(Date date) {
        if ((date.getMonth() == 8) && (date.getDay() > 10))
                return true;
        else
            return false;
    }
    // returns true if date of receipt within the state’s tax free holiday,
    // else returns false. Supporting method of method computeTax.

    
}
