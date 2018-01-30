package bestbuyreceipt_assign3;

/**
 *
 * @author bruce
 */
public class HolidayGreeting implements AddOn, SecondaryHeading{
    
    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }
    public String getLines() {
        return "                * Happy Holidays from Best Buy *";
    }

    
}
