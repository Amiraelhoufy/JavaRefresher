package org.agcodes.designpatterns.adapter;

import java.util.List;

// Legacy Employee and PayItem classes (unchangeable)
public class Employee {

  private final String fullname;

  private final List<PayItem> payItemsList;

  public Employee(String fullname, List<PayItem> payItemsList) {
    this.fullname = fullname;
    this.payItemsList = payItemsList;
  }

  public String getFullname() {
    return fullname;
  }

  public List<PayItem> getPayItemsList() {
    return payItemsList;
  }
}
