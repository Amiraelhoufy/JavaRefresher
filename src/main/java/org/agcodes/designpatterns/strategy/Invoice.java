package org.agcodes.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

// Invoice ↔ InvoiceLine (1:M)
public class Invoice {

  private final Customer customer;
  private final List<InvoiceLine> lines;
  private static final double TAX_PERCENTAGE = 0.10; // 10% tax as a constant percentage

  public Invoice(Customer customer) {
    this.customer = customer;
    this.lines = new ArrayList<>();  // Initialize empty list of invoice lines

  }

  public Customer getCustomer() {
    return customer;
  }

  public List<InvoiceLine> getLines() {
    // Return a copy of the list to avoid external modification and maintain encapsulation.
    return new ArrayList<>(lines);
  }

  public static double getTaxPercentage(){
    return TAX_PERCENTAGE;
  }

//  Add Items to Invoice During Checkout
  public void addInvoiceLines(InvoiceLine invoiceLine){
    lines.add(invoiceLine);
  }

  public double getTotalPrice() {
    return this.lines.stream()
  //1. Lambda Expression:
//        .mapToDouble(line->line.getPrice())
  // 2. Method Reference:
        .mapToDouble(InvoiceLine::getPrice)
        .sum();
  }

  // Calculate the tax
  public double calculateTax() {
    return getTotalPrice() * TAX_PERCENTAGE;
  }

  public double getFinalPriceWithTaxes(){

    return getTotalPrice() + calculateTax();
  }


}
