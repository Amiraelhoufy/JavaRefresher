package org.agcodes.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    // Load the list of customers
    List<Customer> customerList = DataReader.loadData();

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

      // Prompt user for the Invoice price
      System.out.println("Please enter the invoice price: ");
      double price = scanner.nextLong();

      // Prompt user for the Invoice quantity
      System.out.println("Please enter the invoice quantity: ");
      int invoiceQuantity = scanner.nextInt();

      // Create an InvoiceLine and Invoice
      InvoiceLine invoiceLine = new InvoiceLine(price,invoiceQuantity);
      List<InvoiceLine> lines = Arrays.asList(invoiceLine);


      // Using Strategy Manager
      InvoiceManager invoiceManager = new InvoiceManager(customer);
      invoiceManager.createInvoice(customer,lines);

    }else {
      System.out.println("Customer with ID: " + customerId + " not found!");
    }
    // Close the scanner
    scanner.close();


  }

}
