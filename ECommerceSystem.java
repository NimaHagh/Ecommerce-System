import java.net.ProtocolFamily;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/* Name: Nima Hagh Doust
 * Student Number: 501 037 198
 * 
 */

/*
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */
public class ECommerceSystem {
  private ArrayList<Product> products = new ArrayList<Product>();
  private ArrayList<Customer> customers = new ArrayList<Customer>();

  private ArrayList<ProductOrder> orders = new ArrayList<ProductOrder>();
  private ArrayList<ProductOrder> shippedOrders = new ArrayList<ProductOrder>();

  // These variables are used to generate order numbers, customer id's, product
  // id's
  private int orderNumber = 500;
  private int customerId = 900;
  private int productId = 700;

  // General variable used to store an error message when something is invalid
  // (e.g. customer id does not exist)
  String errMsg = null;

  // Random number generator
  Random random = new Random();

  public ECommerceSystem() {
    // NOTE: do not modify or add to these objects!! - the TAs will use for testing
    // If you do the class Shoes bonus, you may add shoe products

    // Create some products. Notice how generateProductId() method is used
    products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney"));
    products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast"));
    products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive"));
    products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney"));
    products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));

    // Create some customers. Notice how generateCustomerId() method is used
    customers.add(new Customer(generateCustomerId(), "Inigo Montoya", "1 SwordMaker Lane, Florin"));
    customers.add(new Customer(generateCustomerId(), "Prince Humperdinck", "The Castle, Florin"));
    customers.add(new Customer(generateCustomerId(), "Andy Dufresne", "Shawshank Prison, Maine"));
    customers.add(new Customer(generateCustomerId(), "Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    // Create some products shoes.
    products.add(new Shoes("Vans Shoes", generateProductId(), 90.00, 9, "Black"));
    products.add(new Shoes("Nike Shoes", generateProductId(), 170.00, 8, "Brown"));
    products.add(new Shoes("Walmart Shoes", generateProductId(), 29, 6, "Black"));
    products.add(new Shoes("New Balance", generateProductId(), 198, 7, "Brown"));

  }

  private String generateOrderNumber() {
    return "" + orderNumber++;
  }

  private String generateCustomerId() {
    return "" + customerId++;
  }

  private String generateProductId() {
    return "" + productId++;
  }

  public String getErrorMessage() {
    return errMsg;
  }

  public void printAllProducts() {
    for (Product p : products)
      p.print();
  }

  // Print all products that are books. See getCategory() method in class Product
  public void printAllBooks() {
    for (Product book : products) {
      if (book.getCategory() == Product.Category.BOOKS) {
        book.print();
      }
    }
  }

  // Print all current orders
  public void printAllOrders()

  {
    for (ProductOrder po : orders) {
      po.print();
    }

  }

  // Print all shipped orders
  public void printAllShippedOrders() {
    for (ProductOrder shipped : shippedOrders) {
      shipped.print();
    }
  }

  // Print all customers
  public void printCustomers() {
    for (Customer custs : customers) {
      custs.print();
    }

  }

  /*
   * Given a customer id, print all the current orders and shipped orders for them
   * (if any)
   */
  public boolean printOrderHistory(String customerId) {
    // Make sure customer exists - check using customerId
    // If customer does not exist, set errMsg String and return false
    // see video for an appropriate error message string
    // ... code here
    // check if customer exists
    Customer CustomerExists = null;
    for (Customer custs : customers) {
      if (custs.getId() == customerId) {
        custs = CustomerExists;

      }
    }
    if (customerId == (null)) { // if it doesnt return false and set err msg
      errMsg = "Customer " + customerId + " Not Found! ";
      return false;
    }

    // Print current orders of this customer
    System.out.println("Current Orders of Customer " + customerId);
    // enter code here
    for (ProductOrder order : orders) {
      if (order.getCustomer().getId() == (customerId)) {
        order.print();
      }
    }

    // Print shipped orders of this customer
    System.out.println("\nShipped Orders of Customer " + customerId);
    // enter code here
    for (ProductOrder shipped : shippedOrders) {
      if (shipped.getCustomer().getId().equals(customerId)) {
        shipped.print();
      }

    }

    return true;
  }

  public String orderProduct(String productId, String customerId, String productOptions) {
    // First check to see if customer object with customerId exists in array list
    // customers
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Customer object
    Customer customer = null;
    for (Customer custs : customers) {
      if (custs.getId().equals(customerId)) {
        customer = custs; // might have to swtich
      }
    }
    if (customer == (null)) {
      errMsg = "Customer " + customerId + " not Found! ";
      return null;

    }

    // Check to see if product object with productId exists in array list of
    // products
    // if it does not, set errMsg and return null (see video for appropriate error
    // message string)
    // else get the Product object
    Product product = null;
    for (Product productz : products) {
      if (productz.getId().equals(productId)) {
        product = productz; // might have to swtich
      }
    }
    if (product == (null)) {
      errMsg = "Product " + productId + " not found! ";
      return null;
    }

    // Check if the options are valid for this product (e.g. Paperback or Hardcover
    // or EBook for Book product)
    // See class Product and class Book for the method vaidOptions()
    // If options are not valid, set errMsg string and return null;
    if (product.validOptions(productOptions) == false) {
      errMsg = "Product in the Category " + product.getCategory() + " not Found! ";
      return null;
    }
    // Check if the product has stock available (i.e. not 0)
    // See class Product and class Book for the method getStockCount()
    // If no stock available, set errMsg string and return null
    int i = 0;
    if (product.getStockCount(productOptions) > 0) {
      i = 1;
    }
    if (i == 0) {
      errMsg = "Product " + productId + " Is out of Stock ";
      return null;
    }

    // Create a ProductOrder, (make use of generateOrderNumber() method above)
    // reduce stock count of product by 1 (see class Product and class Book)
    // Add to orders list and return order number string

    ProductOrder MPO = new ProductOrder(generateOrderNumber(), product, customer, productOptions); // cahnge name
    product.reduceStockCount(productOptions); // check might change
    orders.add(MPO);
    return MPO.getOrderNumber();

  }

  /*
   * Create a new Customer object and add it to the list of customers
   */

  public boolean createCustomer(String name, String address) {
    // Check name parameter to make sure it is not null or ""
    // If it is not a valid name, set errMsg (see video) and return false
    // Repeat this check for address parameter
    if (name.equals("") || name == (null) || name.equals(" ")) {
      errMsg = "Invalid Customer: " + name + " Name! ";
      return false;
    }
    if (address.equals(null) || address.equals("") || address.equals(" ")) {
      errMsg = "Invalid Customer Address " + address;
      return false;
    }

    // Create a Customer object and add to array list

    Customer custobj = new Customer(generateCustomerId(), name, address);
    customers.add(custobj);
    return true;

  }

  public ProductOrder shipOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return false
    // Retrieve the order from the orders array list, remove it, then add it to the
    // shippedOrders array list
    // return a reference to the order
    int iz = orders.indexOf(new ProductOrder(orderNumber, null, null, ""));
    if (iz == -1) {
      errMsg = "Order " + orderNumber + " Not Found";
      return null; // typo in the comment
    }
    ProductOrder order = orders.get(iz);

    orders.remove(iz); // removing the specific order form the orders
    shippedOrders.add(order); // adding the order to shipped
    return order;

  }

  /*
   * Cancel a specific order based on order number
   */
  public boolean cancelOrder(String orderNumber) {
    // Check if order number exists first. If it doesn't, set errMsg to a message
    // (see video)
    // and return false

    int iz = orders.indexOf(new ProductOrder(orderNumber, null, null, ""));
    if (iz == -1) {
      errMsg = " Order " + orderNumber + " Not Found ";
      return false;
    }

    ProductOrder order = orders.get(iz);

    orders.remove(iz); // removing the order that needs to get removed in the array list
    return true;

  }
  // ___________________________GOOD TILL HERE_______________________

  // Sort products by increasing price
  public void sortByPrice() {
    Collections.sort(products, new PriceComparator()); // made a new file for the Comparator

  }

  // Sort products alphabetically by product name
  public void sortByName() {
    Collections.sort(products, new ProductNameComparator());// made a new file for the Comparator
    // System.out.println(products);

  }

  // Sort products alphabetically by product name
  public void sortCustomersByName() {
    Collections.sort(customers, new CustomerNameComparator());// made a new file for the Comparator

  }
}
