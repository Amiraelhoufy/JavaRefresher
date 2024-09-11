package org.agcodes.designpatterns.strategy;

public class NewCustomerDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double applyDiscount(double totalPrice) {
    // No discount
    return totalPrice;
  }
}
