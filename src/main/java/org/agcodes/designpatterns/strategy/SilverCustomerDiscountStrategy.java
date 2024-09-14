package org.agcodes.designpatterns.strategy;

public class SilverCustomerDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double calculateCategoryDiscount(double totalPrice) {
    // 5% discount or No discount
    return totalPrice>= 10000? totalPrice* 0.05 : 0;
  }
}
