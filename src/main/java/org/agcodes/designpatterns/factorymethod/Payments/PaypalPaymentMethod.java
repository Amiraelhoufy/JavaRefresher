package org.agcodes.designpatterns.factorymethod.Payments;

import java.util.UUID;
import org.agcodes.designpatterns.factorymethod.IPaymentMethod;
import org.agcodes.designpatterns.factorymethod.Payment;

public class PaypalPaymentMethod implements IPaymentMethod {

  @Override
  public Payment charge(long customerId, double amount) {
    double chargeAmount = amount>10000? amount+ (amount*0.02): amount;
    return new Payment(customerId, chargeAmount, UUID.randomUUID());
  }
}
