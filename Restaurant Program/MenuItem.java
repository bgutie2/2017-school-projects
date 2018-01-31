package restaurant_program;

/**
 *
 * @author bruce
 */
public class MenuItem {
    
    private String item;
    private String name;
    private String price;
    private int item_type;
    
    public MenuItem(String item, String name, String price, int item_type) {
        this.item = item;
        this.name = name;
        this.price = price;
        this.item_type = item_type;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
    
    public String getItemNumber() {
        return item;
    }
    
    public int getItemType() {
        return item_type;
    }
    
    public String descript() {
        String descript = String.format("%-10s %-25s  $%s",item,name,price); //formats the description
        return descript;
    }
    
}
