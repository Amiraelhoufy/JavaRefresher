package org.agcodes.designpatterns.templatemethod;

public class OnlineShoppingCart extends ShoppingCart{
  private static final double ONLINE_DISCOUNT_RATE = 0.05; // 5% discount

  @Override
  protected double calculateDiscount(double totalWithTax) {
    return totalWithTax * ONLINE_DISCOUNT_RATE;
  }
}
