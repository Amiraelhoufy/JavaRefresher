package org.agcodes.designpatterns.adapter;

// New PayItem class with the isDeduction field
public class NewPayItem {

  private final String name;
  private final double value;
  private final boolean isDeduction;

  public NewPayItem(String name, double value, boolean isDeduction) {
    this.name = name;
    this.value = value;
    this.isDeduction = isDeduction;
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }

  public boolean getIsDeduction() {
    return isDeduction;
  }
}
