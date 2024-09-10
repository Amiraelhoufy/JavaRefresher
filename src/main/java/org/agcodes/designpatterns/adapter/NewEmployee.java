package org.agcodes.designpatterns.adapter;

import java.util.List;

// New Employee System with First/Last names and deduction flag
public class NewEmployee {

  private final String firstName;
  private final String lastName;
  private final List<NewPayItem> newPayItemList;

  public NewEmployee(String firstName, String lastName, List<NewPayItem> newPayItemList) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.newPayItemList = newPayItemList;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<NewPayItem> getNewPayItemList() {
    return newPayItemList;
  }
}
