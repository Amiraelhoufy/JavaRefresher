package org.agcodes.designpatterns.templatemethod;

public class InstoreShoppingCart extends ShoppingCart{

  @Override
  protected double calculateDiscount(double totalWithTax) {
    return 0;
  }
}
