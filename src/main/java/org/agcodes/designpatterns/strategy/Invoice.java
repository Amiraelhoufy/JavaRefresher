package org.agcodes.designpatterns.strategy;

import java.util.ArrayList;
import java.util.List;

public class Invoice {

  private final Customer customer;
  private final List<InvoiceLine> lines;
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


}
