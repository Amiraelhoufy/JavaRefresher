package org.agcodes.designpatterns.factorymethod;

import org.agcodes.designpatterns.factorymethod.Payments.PaypalPaymentMethod;

public class PaypalPaymentProcessor extends PaymentProcessor{

  @Override
  protected IPaymentMethod createPaymentMethod() {
    return new PaypalPaymentMethod();
  }
}
