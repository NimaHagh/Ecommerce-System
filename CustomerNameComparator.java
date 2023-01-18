import java.util.Comparator;
/* Name: Nima Hagh Doust
 * Student Number: 501 037 198
 * 
 */

/* 
 * A Comparator that sorts the Customers by Name 
 * 
 */

public class CustomerNameComparator  implements Comparator<Customer>  {
    public int compare(Customer a, Customer b){
        return a.getName().compareTo(b.getName()); 
    }
    
}
