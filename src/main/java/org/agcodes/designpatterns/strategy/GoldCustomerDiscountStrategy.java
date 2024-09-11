package org.agcodes.designpatterns.strategy;

public class GoldCustomerDiscountStrategy implements ICustomerDiscountStrategy {

  @Override
  public double applyDiscount(double totalPrice) {
    // 10% discount or No discount
    return totalPrice>=10000? totalPrice* 0.9: totalPrice;
  }
}
