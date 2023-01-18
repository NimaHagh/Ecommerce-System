Ecommerce Project

  This is a Java based ecommerce system that uses the terminal for input and output. It allows for the creation of new customers, listing of all products and books for sale, and tracking of customer orders. The project uses inheritance and polymorphism to manage various classes and objects.

How to use: 

  Open the terminal and navigate to the directory where the project is located.
  Compile and run the ECommerceUserInterface class by typing javac ECommerceUserInterface.java and then java ECommerceUserInterface.
  The system will prompt > where the user can input commands.
  The following commands are available:
  PRODS: Lists all products for sale.
  BOOKS: Lists all books for sale.
  CUSTS: Lists all registered customers.
  ORDERS: Lists all current product orders.
  SHIPPED: Lists all orders that have been shipped.
  NEWCUST: Creates a new registered customer.
  SHIP: Ships an order to a customer.
  CUSTORDERS: Lists all the current orders and shipped orders for a specific customer id.
  Q or QUIT: Exits the system.
  
Error handling has been implemented, if an invalid command is entered or an error occurs, the system will output an error message.

Code Structure:

  The ECommerceUserInterface class contains the main method and handles user input and output.
  The ECommerceSystem class contains the necessary methods for creating customers, listing products and books, and tracking orders. 
  Other classes such as Product, Book, and Customer, are used in conjunction with the ECommerceSystem class to manage the various objects and their properties.

Note:
  This project is a simulation of ecommerce system and it does not interact with any external service or database.




