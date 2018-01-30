package bestbuyreceipt_assign3;

/**
 *
 * @author bruce
 */
abstract public class Decorator implements Receipt {
    
    private Receipt trailer;
    
    public Decorator(Receipt r) {
        trailer = r;
    }
    
    protected void callTrailer() {
        trailer.prtReceipt();
    }
    
    public abstract void prtReceipt();
    
}
