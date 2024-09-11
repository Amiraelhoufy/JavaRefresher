package org.agcodes.designpatterns.strategy;

public class Customer {

  // Enum defined inside the class, tightly coupled with Customer
  public enum CustomerCategory {
    NEW,
    SILVER,
    GOLD,
    NONE
  }

  private final long ID;
  private final String name;

  private final CustomerCategory category;

  public Customer(long ID, String name, CustomerCategory category) {
    this.ID = ID;
    this.name = name;
    this.category = category;
  }

  public long getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public CustomerCategory getCategory() {
    return category;
  }
}
