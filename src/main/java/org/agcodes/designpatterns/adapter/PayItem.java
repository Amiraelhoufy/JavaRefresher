package org.agcodes.designpatterns.adapter;

public class PayItem {

  private final String name;
  private final double value;

  public PayItem(String name, double value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public double getValue() {
    return value;
  }
}
