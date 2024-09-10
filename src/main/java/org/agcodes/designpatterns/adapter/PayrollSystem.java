package org.agcodes.designpatterns.adapter;

// The legacy Payroll System that we can't modify
public class PayrollSystem {

  public double calculatePayroll(Employee employee){
    double totalPayroll = 0;
/*
    for(PayItem item: employee.getPayItemsList()){
      totalPayroll+= item.getValue();
    }
*/

    totalPayroll += employee.getPayItemsList().stream()
        .mapToDouble(PayItem::getValue).sum();

    System.out.println("Payroll calculated for " + employee.getFullname() + ": " + totalPayroll + " USD");

    return totalPayroll;
  }

}
