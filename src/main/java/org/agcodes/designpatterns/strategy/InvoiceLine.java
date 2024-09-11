package org.agcodes.designpatterns.strategy;

public class InvoiceLine {

  private final double unitPrice;
  private final int quantity;

  public InvoiceLine(double unitPrice, int quantity) {
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  public double getUnitPrice() {
    return unitPrice;
  }

  public int getQuantity() {
    return quantity;
  }
  // Calculate total price for this invoice line (unitPrice * quantity)
  public double getPrice() {
    return unitPrice * quantity;
  }
}
