package org.agcodes.designpatterns.nullobject;

import org.agcodes.designpatterns.strategy.ICustomerDiscountStrategy;

public class NullDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double applyDiscount(double totalPrice) {
    // No discount applied
    return totalPrice;
  }
}
