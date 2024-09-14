package org.agcodes.designpatterns.strategy;

import static org.agcodes.designpatterns.strategy.Customer.CustomerCategory.*;

import java.util.List;
import org.agcodes.designpatterns.simplefactory.CustomerDiscountStrategyFactory;


public class InvoiceManager {

  private ICustomerDiscountStrategy discountStrategy;

  public InvoiceManager(Customer customer) {

    this.discountStrategy = CustomerDiscountStrategyFactory.createCustomerDiscountStrategy(customer);
   /* switch (customer.getCategory()) {
      case NEW:
        this.discountStrategy = new NewCustomerDiscountStrategy();
        break;

      case GOLD:
        this.discountStrategy = new GoldCustomerDiscountStrategy();
        break;

      case SILVER:
        this.discountStrategy = new SilverCustomerDiscountStrategy();
        break;

      default:
        throw new IllegalArgumentException("unknown customer category");
    }*/
  }

  public Invoice createInvoice(Customer customer, List<InvoiceLine> invoicelines){

    Invoice invoice = new Invoice(customer);
    invoicelines.stream().forEach(
        invoiceline -> {
      invoice.addInvoiceLines(invoiceline);
    });

    double totalPrice = invoice.getTotalPrice();
    // Apply discount based on customer category
    double calculatedDiscount = discountStrategy.calculateCategoryDiscount(totalPrice);
    double finalPrice = totalPrice - calculatedDiscount;

    // Print invoice details
    System.out.println("Invoice created for customer: " + customer.getName());
    System.out.println("Original Total price: " + totalPrice + " USD");
    System.out.println("Final Total price after discount: " + finalPrice + " USD");


    return invoice;

  }



}
