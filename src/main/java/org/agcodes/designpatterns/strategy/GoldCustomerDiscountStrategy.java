package org.agcodes.designpatterns.strategy;

public class GoldCustomerDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double calculateCategoryDiscount(double totalPrice) {
    // 10% discount or No discount
    return totalPrice>=10000? totalPrice* 0.10: 0;
  }
}
