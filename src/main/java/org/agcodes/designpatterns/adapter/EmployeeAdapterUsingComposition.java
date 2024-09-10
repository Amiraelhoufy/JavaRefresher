package org.agcodes.designpatterns.adapter;


import java.util.List;
import java.util.stream.Collectors;

//Using composition instead of inheritance in the adapter pattern is a cleaner and more flexible approach.
public class EmployeeAdapterUsingComposition {

  private final NewEmployee newEmployee;

  public EmployeeAdapterUsingComposition(NewEmployee newEmployee) {
    this.newEmployee = newEmployee;
  }

  // Adapt the new employee to the legacy employee format
  public Employee getLegacyEmployee() {
    String fullName = newEmployee.getFirstName() + " " + newEmployee.getLastName();
    List<PayItem> payItemList = convertPayItems(newEmployee.getNewPayItemList());
    return new Employee(fullName,payItemList);
  }

  private List<PayItem> convertPayItems(List<NewPayItem> newPayItemList) {

    return newPayItemList.stream()
        .map(item -> new PayItem(
            item.getName(),
            item.getIsDeduction()? -item.getValue(): item.getValue()
        ))
        .collect(Collectors.toList());
  }
}