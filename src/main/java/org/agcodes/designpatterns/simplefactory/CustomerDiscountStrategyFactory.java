package org.agcodes.designpatterns.simplefactory;

import org.agcodes.designpatterns.nullobject.NullDiscountStrategy;
import org.agcodes.designpatterns.strategy.Customer;
import org.agcodes.designpatterns.strategy.GoldCustomerDiscountStrategy;
import org.agcodes.designpatterns.strategy.ICustomerDiscountStrategy;
import org.agcodes.designpatterns.strategy.NewCustomerDiscountStrategy;
import org.agcodes.designpatterns.strategy.SilverCustomerDiscountStrategy;

public class CustomerDiscountStrategyFactory {

  public static ICustomerDiscountStrategy createCustomerDiscountStrategy(Customer customer){

    if (customer.getCategory() == null) {
      return new NullDiscountStrategy();  // Default strategy when category is null
    }

    switch (customer.getCategory()) {
      case NEW:
        return new NewCustomerDiscountStrategy();
      case GOLD:
        return new GoldCustomerDiscountStrategy();
      case SILVER:
        return new SilverCustomerDiscountStrategy();
      default:
        return new NullDiscountStrategy();  // Default strategy for unknown categories
//        throw new IllegalArgumentException("unknown customer category");
    }

  }

}
