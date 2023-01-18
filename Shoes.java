/* Name: Nima Hagh Doust
 * Student Number: 501 037 198
 * 
 */

/* A Shoe IS A product that has additional information - e.g. size,color

 	 A shoe also comes in different colors (black, brown) and 
      sizes( 6, 7, 8, 9, 10)
 	 
 	

*/
import java.util.ArrayList;
import java.util.Collections;

public class Shoes extends Product {
    private int size; // the size of the shoe
    private String color; // color of the shoe

    int BlackStockCount; // keep track of the black stock count
    int BrownStockCount; // keep trakc of the brown stock count
    int size6StockCount;
    int size7StockCount;
    int size8StockCount;
    int size9StockCount;
    int size10StockCount;

   

    public Shoes(String name, String id, double price, int size, String color) {
        super(name, id, price, 100000, Product.Category.SHOES);
        this.size = size;
        this.color = color;

    }

    public boolean validColorOptions(String productOptions) {
        // check productOptions for "Black" or "Brown"
        // if it is one of these, return true, else return false

        if (productOptions.equals("Black") || productOptions.equals("Brown")) {
            return true;
        }
        return false;
    }

    public boolean validShoeSizeOptions(int size) {

        if (size == 6 || size == 7 || size == 8 || size == 9 || size == 10) {
            return true;
        }
        return false;
    }

    // Override getStockCount() in super class.
    public int getStockCount(String productOptions) {
        // Use the productOptions to check for (and return) the number of stock for
        // "Black" etc
        // Just like E book Assuming we have in stock in every size

        if (productOptions.equals("Black")) {
            return BlackStockCount;
        }
        if (productOptions.equals("Brown")) {
            return BrownStockCount;
        }
        if (size == 6) {
            return size6StockCount;
        }
        if (size == 7) {
            return size7StockCount;
        }
        if (size == 8) {
            return size8StockCount;
        }
        if (size == 9) {
            return size9StockCount;
        }
        if (size == 10) {
            return size10StockCount;
        }

        return 1;

    }

    public void setStockCount(int stockCount, String productOptions) {
        // Use the productOptions to check for (and set) the number of stock for
        // "Black" etc
        // Use the variables paperbackStock and hardcoverStock at the top.
        // For "EBook", set the inherited stockCount variable.
        if (productOptions.equals("Black")) {
            BlackStockCount = stockCount;
        }
        if (productOptions.equals("Brown")) {
            BrownStockCount = stockCount;
        }
        if (size == 6) {
            size6StockCount = stockCount;
        }
        if (size == 7) {
            size7StockCount = stockCount;
        }
        if (size == 8) {
            size8StockCount = stockCount;
        }
        if (size == 9) {
            size9StockCount = stockCount;
        }
        if (size == 9) {
            size9StockCount = stockCount;
        }
    }

    /*
     * When a Shoe is ordered, reduce the stock count for the specific stock type
     */
    public void reduceStockCount(String productOptions) {
        // Use the productOptions to check for (and reduce) the number of stock for
        // "BlackShoes" etc
        if (productOptions.equals("Black")) {
            BlackStockCount--;
        }
        if (productOptions.equals("Brown")) {
            BrownStockCount--;
        }
        if (size == 6) {
            size6StockCount--;
        }
        if (size == 7) {
            size7StockCount--;
        }
        if (size == 8) {
            size8StockCount--;
        }
        if (size == 9) {
            size9StockCount--;
        }
        if (size == 10) {
            size10StockCount--;
        }
    }
    /*
     * Print Statement
     */

    public void print() {

        super.print(); // normal super information
        System.out.print("Color: " + color + " Size: " + size);

    }

}
