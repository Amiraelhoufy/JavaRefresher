package org.agcodes.designpatterns.strategy;

public class ItemID {

  private final long id;
  private final String name;

  private final double unitPrice;

  public ItemID(long id, String name, double unitPrice) {
    this.id = id;
    this.name = name;
    this.unitPrice = unitPrice;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getUnitPrice() {
    return unitPrice;
  }
}
