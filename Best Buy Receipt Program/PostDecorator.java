package bestbuyreceipt_assign3;

/**
 *
 * @author bruce
 */
public class PostDecorator extends Decorator {
    
    private AddOn a;
    
    public PostDecorator(AddOn a, Receipt r) {
        super(r);
        this.a = a;
    }
    
    public void prtReceipt() {
        callTrailer();
        System.out.println(a.getLines());
    }
    
}
