package org.agcodes.designpatterns.strategy;
// itemId ↔ InvoiceLine (1:1)
public class InvoiceLine {

  private final ItemID itemID;
  private final double unitPrice;
  private final int quantity;


  public InvoiceLine(ItemID itemID, double unitPrice, int quantity) {
    this.itemID = itemID;
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
