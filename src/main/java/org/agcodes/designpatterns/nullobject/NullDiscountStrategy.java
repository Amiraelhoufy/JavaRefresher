package org.agcodes.designpatterns.nullobject;

import org.agcodes.designpatterns.strategy.ICustomerDiscountStrategy;

public class NullDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double calculateCategoryDiscount(double totalPrice) {
    // No discount applied
    return 0;
  }
}
