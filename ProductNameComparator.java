

import java.util.Comparator;




/* Name: Nima Hagh Doust
 * Student Number: 501 037 198
 * 
 */



 /* 
 * A Comparator that sorts the Products by Name (Alphab) 
 * 
 */
public class ProductNameComparator implements Comparator<Product> {
    public int compare(Product a, Product b){
        return a.getName().compareTo(b.getName());

    }
    
}
