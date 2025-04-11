package org.agcodes.designpatterns.factorymethod;

public interface IPaymentMethod {

  Payment charge(long customerId, double amount);
}
