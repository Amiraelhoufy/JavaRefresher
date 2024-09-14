package org.agcodes.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import org.agcodes.designpatterns.templatemethod.InstoreShoppingCart;
import org.agcodes.designpatterns.templatemethod.OnlineShoppingCart;
import org.agcodes.designpatterns.templatemethod.ShoppingCart;

public class Main {

  public static void main(String[] args) {

    // Load the list of customers
    List<Customer> customerList = CustomerDataReader.loadData();

    // Printing the customers info
    System.out.println("----------- Customers -----------");
    customerList.stream().forEach(customer -> {
      System.out.println(customer.getID() +": " +customer.getName() + " (" + customer.getCategory() + ")");
    });

    // Load the list of items
    List<ItemID> itemIDList= ItemDataReader.loadData();

    // Printing the items info
    System.out.println("----------- Items -----------");
    itemIDList.stream().forEach(itemID -> {
      System.out.println(itemID.getId() + ": " + itemID.getName() + " [" + itemID.getUnitPrice() + " USD ]");
    });

    System.out.println("----------- New Invoice -----------");
    // Create a scanner object to read user input
    Scanner scanner = new Scanner(System.in);

    // Prompt user for the customer ID
    System.out.println("Please enter the customer id: ");
    long customerId = scanner.nextLong();

    // Find the customer by ID
    Optional<Customer> optionalCustomer  = customerList.stream()
        .filter(customer -> customer.getID() == customerId)
        .findFirst();

    if(optionalCustomer.isPresent()){

      Customer customer = optionalCustomer.get();

      // Prompt user for shoppingCart type
      System.out.println("Please enter the Shopping cart type: (online:instore) ");
      String cartType  = scanner.next();

      ShoppingCart shoppingCart =  cartType.equalsIgnoreCase("online")
          ? new OnlineShoppingCart()
          :new InstoreShoppingCart();


      int id;

      while(true){
      // Prompt user for the Item id
      System.out.println("Please enter the itemID from the List or 0 to exist: ");
        id = scanner.nextInt();

        if (id == 0) {
          break; // Exit loop if id is 0
        }

        final int finalId = id; // Copy id to a final variable to be used in lambda
        Optional<ItemID> itemId = itemIDList.stream()
            .filter(item -> item.getId() == finalId)
            .findFirst();

        if(itemId.isPresent()){

        ItemID item = itemId.get();
      // Prompt user for the Invoice quantity
      System.out.println("Please enter the item quantity: ");
      int invoiceQuantity = scanner.nextInt();

      // Create an InvoiceLine and Invoice
      InvoiceLine invoiceLine = new InvoiceLine(item,item.getUnitPrice(),invoiceQuantity);


     // Adding the InvoiceLine to the ShoppingCart
      shoppingCart.addItem(item,invoiceQuantity);

        }}

      // Using Strategy Manager

    /*  InvoiceManager invoiceManager = new InvoiceManager(customer);
      invoiceManager.createInvoice(customer,shoppingCart.getInvoiceLines());
      */

      // Perform checkout and generate invoice
      Invoice invoice = shoppingCart.checkout(customer);

    }else {
      System.out.println("Customer with ID: " + customerId + " not found!");
    }


    // Close the scanner
    scanner.close();


  }

}
