import java.util.Comparator;



/* 
 * Creates the comparator for the array list price  
 * 
 */

public class PriceComparator implements Comparator<Product> {
    public int compare(Product a, Product b) {
        if (a.getPrice() == b.getPrice()) {
            return 0;
        } else if (a.getPrice() > b.getPrice()) {
            return 1;
        }
        return -1;

    }

}
