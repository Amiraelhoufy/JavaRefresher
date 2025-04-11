package org.agcodes.designpatterns.factorymethod;

import org.agcodes.designpatterns.factorymethod.Payments.VisaPaymentMethod;

public class VisaPaymentProcessor extends PaymentProcessor {

  @Override
  protected IPaymentMethod createPaymentMethod() {
    return new VisaPaymentMethod();
  }
}
