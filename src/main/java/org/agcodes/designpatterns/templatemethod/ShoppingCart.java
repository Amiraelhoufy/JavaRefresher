package org.agcodes.designpatterns.templatemethod;

import java.util.ArrayList;
import java.util.List;
import org.agcodes.designpatterns.strategy.Customer;
import org.agcodes.designpatterns.strategy.Invoice;
import org.agcodes.designpatterns.strategy.InvoiceLine;
import org.agcodes.designpatterns.strategy.ItemID;

// Responsible for managing items during the shopping process
// adding/removing items and handling totals before checkout
public abstract class ShoppingCart {

  private final List<InvoiceLine> invoiceLines= new ArrayList<>();
  public void addItem(ItemID itemId,int quantity){
  InvoiceLine line = new InvoiceLine(itemId,itemId.getUnitPrice(),quantity);
  invoiceLines.add(line);
}

public List<InvoiceLine> getInvoiceLines(){
  return invoiceLines;
}

protected abstract double calculateDiscount(double totalWithTax);

public Invoice checkout(Customer customer){

  Invoice invoice = new Invoice(customer);
  // Add all invoice lines to the invoice
  invoiceLines.forEach(invoice::addInvoiceLines);

  double totalPriceBeforeTax = invoice.getTotalPrice();
  // 1- Apply tax
  double finalPriceWithTaxes = invoice.getFinalPriceWithTaxes();
  // 2- Apply discount
  double calculatedDiscount = calculateDiscount(finalPriceWithTaxes);
  double finalPriceWithTaxesAndDiscount = finalPriceWithTaxes - calculatedDiscount;

  // 3- process payment
  System.out.println("Total Before Tax: " + totalPriceBeforeTax);
  System.out.println("Tax Amount After Tax: " + finalPriceWithTaxes);
  System.out.println("Discount Amount: " + calculatedDiscount);
  System.out.println("Total After Tax & Discount: " + finalPriceWithTaxesAndDiscount);

  System.out.println("Invoice created for customer: " + customer.getName());

  return invoice;
}
}
