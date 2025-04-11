package org.agcodes.designpatterns.factorymethod.Payments;

import java.util.UUID;
import org.agcodes.designpatterns.factorymethod.IPaymentMethod;
import org.agcodes.designpatterns.factorymethod.Payment;

public class VisaPaymentMethod implements IPaymentMethod {

  @Override
  public Payment charge(long customerId, double amount) {
    double chargeAmount = amount+ (amount*0.05);
    return new Payment(customerId, chargeAmount, UUID.randomUUID());
  }
}
