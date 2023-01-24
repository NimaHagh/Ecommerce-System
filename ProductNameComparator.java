

import java.util.Comparator;




 /* 
 * A Comparator that sorts the Products by Name (Alphab) 
 * 
 */
public class ProductNameComparator implements Comparator<Product> {
    public int compare(Product a, Product b){
        return a.getName().compareTo(b.getName());

    }
    
}
