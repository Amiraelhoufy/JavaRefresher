package org.agcodes.designpatterns.strategy;

public class NewCustomerDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double calculateCategoryDiscount(double totalPrice) {
    // No discount
    return 0;
  }
}
