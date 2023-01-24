import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



// Simulation of a Simple E-Commerce System (like Amazon)

public class ECommerceUserInterface {
	public static void main(String[] args) {
		// Create the system
		ECommerceSystem amazon = new ECommerceSystem();

		Scanner scanner = new Scanner(System.in);
		System.out.print(">");

		// Process keyboard actions
		while (scanner.hasNextLine()) {
			String action = scanner.nextLine();

			if (action == null || action.equals("")) {
				System.out.print("\n>");
				continue;
			} else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT"))
				return;

			else if (action.equalsIgnoreCase("PRODS")) // List all products for sale
			{
				amazon.printAllProducts();
			} else if (action.equalsIgnoreCase("BOOKS")) // List all books for sale
			{
				amazon.printAllBooks();
			} else if (action.equalsIgnoreCase("CUSTS")) // List all registered customers
			{
				amazon.printCustomers();
			} else if (action.equalsIgnoreCase("ORDERS")) // List all current product orders
			{
				amazon.printAllOrders();
			} else if (action.equalsIgnoreCase("SHIPPED")) // List all orders that have been shipped
			{
				amazon.printAllShippedOrders();
			} else if (action.equalsIgnoreCase("NEWCUST")) // Create a new registered customer
			{ // if the input is NEWCUST
				String name = "";
				String address = "";

				System.out.print("Name: ");
				if (scanner.hasNextLine())
					name = scanner.nextLine();

				System.out.print("\nAddress: ");
				if (scanner.hasNextLine())
					address = scanner.nextLine();

				boolean success = amazon.createCustomer(name, address);
				if (!success) {
					System.out.println(amazon.getErrorMessage());
				}
			} // good

			else if (action.equalsIgnoreCase("SHIP")) // ship an order to a customer
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// Get order number from scanner
				if (scanner.hasNextLine()) {
					orderNumber = scanner.nextLine();
				}

				// Ship order to customer (see ECommerceSystem for the correct method to use

				ProductOrder sucess0 = amazon.shipOrder(orderNumber); // might have to change
				if (sucess0 == null) {
					System.out.println(amazon.getErrorMessage());

				} // good

			} else if (action.equalsIgnoreCase("CUSTORDERS")) // List all the current orders and shipped orders for this
																// customer id
			{
				String customerId = "";

				System.out.print("Customer Id: ");
				// Get customer Id from scanner
				if (scanner.hasNextLine()) {
					customerId = scanner.nextLine();
				}
				// Print all current orders and all shipped orders for this customer
				boolean x = amazon.printOrderHistory(customerId); // might need to remove the system.out
				if (!x) {
					System.out.println(amazon.getErrorMessage());
				}

			} else if (action.equalsIgnoreCase("ORDER")) // order a product for a certain customer
			{
				String productId = "";
				String customerId = "";

				System.out.print("Product Id: ");
				// Get product Id from scanner
				if (scanner.hasNextLine()) {
					productId = scanner.nextLine();
				}

				System.out.print("\nCustomer Id: ");
				// Get customer Id from scanner
				if (scanner.hasNextLine()) {
					customerId = scanner.nextLine();
				}

				// Order the product. Check for valid orderNumber string return and for error
				// message set in ECommerceSystem
				String y= amazon.orderProduct(productId, customerId, "");
				if (y == null) {
					System.out.println(amazon.getErrorMessage());

				}

				// Print Order Number string returned from method in ECommerceSystem
				System.out.println(y);
				// Shows twice fix later
			} else if (action.equalsIgnoreCase("ORDERBOOK")) // order a book for a customer, provide a format
																// (Paperback, Hardcover or EBook)
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				if (scanner.hasNextLine()) {
					productId = scanner.nextLine();
				}

				System.out.print("\nCustomer Id: ");
				// get customer id
				if (scanner.hasNextLine()) {
					customerId = scanner.nextLine();
				}

				System.out.print("\nFormat [Paperback Hardcover EBook]: ");
				// get book forma and store in options string
				if (scanner.hasNextLine()) {
					options = scanner.nextLine();
				}

				// Order product. Check for error mesage set in ECommerceSystem
				// amazon.orderProduct(productId, customerId, options);
				if ((amazon.orderProduct(productId, customerId, options)==null)) {
					System.out.println(amazon.getErrorMessage());
				}

				// Print order number string if order number is not null
				// else if (amazon.orderProduct(productId, customerId, options) == null) {
				// 	System.out.println(amazon.getErrorMessage());
				// }

			} else if (action.equalsIgnoreCase("ORDERSHOES")) // order shoes for a customer, provide size and color
			{
				String productId = "";
				String customerId = "";
				String options = "";

				System.out.print("Product Id: ");
				// get product id
				if (scanner.hasNextLine()) {
					productId = scanner.nextLine();
				}

				System.out.print("\nCustomer Id: ");
				// get customer id
				if (scanner.hasNextLine()) {
					customerId = scanner.nextLine();
				}

				System.out.print("\nSize: \"6\" \"7\" \"8\" \"9\" \"10\": ");
				// get shoe size and store in options
				if (scanner.hasNextLine()) {
					options= scanner.nextLine();
				}

				System.out.print("\nColor: \"Black\" \"Brown\": ");
				// get shoe color and append to options
				if (scanner.hasNextLine()) {
					options= scanner.nextLine();
				}
				

				// order shoes
				if ((amazon.orderProduct(productId, customerId, options)==null)) {
					System.out.println(amazon.getErrorMessage());
				}
			}

			else if (action.equalsIgnoreCase("CANCEL")) // Cancel an existing order
			{
				String orderNumber = "";

				System.out.print("Order Number: ");
				// get order number from scanner
				if (scanner.hasNextLine()) {
					orderNumber = scanner.nextLine();
				}

				// cancel order. Check for error

				boolean cancelme = amazon.cancelOrder(orderNumber);
				if (!cancelme) {
					System.out.println(amazon.getErrorMessage());

				} // good

			} else if (action.equalsIgnoreCase("SORTBYPRICE")) // sort products by price
			{
				amazon.sortByPrice();
			} else if (action.equalsIgnoreCase("SORTBYNAME")) // sort products by name (alphabetic)
			{
				amazon.sortByName();
			} else if (action.equalsIgnoreCase("SORTCUSTS")) // sort products by name (alphabetic)
			{
				amazon.sortCustomersByName();
			}
			System.out.print("\n>");
		}
	}
}
