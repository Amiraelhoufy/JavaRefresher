package org.agcodes.designpatterns.factorymethod;

public abstract class PaymentProcessor {

  public Payment processMethod(long customerId, double amount){
    IPaymentMethod paymentMethod = createPaymentMethod();
    Payment payment = paymentMethod.charge(customerId,amount);
    return payment;

  }

  // we don't know the available payment methods (Abstraction Layer)
  protected abstract IPaymentMethod createPaymentMethod();

}
