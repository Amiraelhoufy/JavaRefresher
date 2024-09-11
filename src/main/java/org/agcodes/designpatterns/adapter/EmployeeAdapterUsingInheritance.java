package org.agcodes.designpatterns.adapter;

import java.util.List;
import java.util.stream.Collectors;

// Adapter class to adapt NewEmployee to the Employee type used in the Payroll System
public class EmployeeAdapterUsingInheritance extends Employee {

  //private final NewEmployee newEmployee;

  public EmployeeAdapterUsingInheritance(NewEmployee newEmployee) {
    super(
        newEmployee.getFirstName() + " " + newEmployee.getLastName(),
        convertPayItems(newEmployee.getNewPayItemList())
    );
    // Store the NewEmployee object for potential future use
    //this.newEmployee = newEmployee;

  }
  // Convert new pay items to legacy pay items
private static List<PayItem> convertPayItems(List<NewPayItem> newPayItems){

    return newPayItems.stream().
        map(item-> new PayItem(
            item.getName(),
            item.getIsDeduction()? -item.getValue() : item.getValue()
        ))
        .collect(Collectors.toList());
}

}
