package org.agcodes.designpatterns.factorymethod;

import java.util.UUID;

public class Payment {

  private long customerId;
  private double chargeAmount;
  private UUID referenceNumber;

  public Payment(long customerId, double chargeAmount, UUID referenceNumber) {
    this.customerId = customerId;
    this.chargeAmount = chargeAmount;
    this.referenceNumber = referenceNumber;
  }

  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

  public double getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(double chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public UUID getReferenceNumber() {
    return referenceNumber;
  }

  public void setReferenceNumber(UUID referenceNumber) {this.referenceNumber = referenceNumber;}
}
