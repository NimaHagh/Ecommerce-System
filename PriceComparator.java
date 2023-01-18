import java.util.Comparator;

/* Name: Nima Hagh Doust
 * Student Number: 501 037 198
 * 
 */

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
