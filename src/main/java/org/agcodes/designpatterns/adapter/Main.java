package org.agcodes.designpatterns.adapter;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    // Load the new employee data
    List<NewEmployee> newEmployees = EmployeeReader.loadEmployeeData();

    // Create the payroll system
    PayrollSystem payrollSystem = new PayrollSystem();

    // Adapt the new employees to the legacy payroll system
    // 1- Adapter design pattern Implemented using Inheritance
    System.out.println("1- Adapter design pattern Implemented using Inheritance");
    for (NewEmployee employee : newEmployees) {
      Employee adaptedEmployee = new EmployeeAdapterUsingInheritance(employee);
      payrollSystem.calculatePayroll(adaptedEmployee);
    }


    // 2- Adapter design pattern Implemented using Composition
    System.out.println("2- Adapter design pattern Implemented using Composition");
    for (NewEmployee employee:newEmployees){
      Employee adaptedEmployee = new EmployeeAdapterUsingComposition(employee).getLegacyEmployee();
      payrollSystem.calculatePayroll(adaptedEmployee);
    }




  }

}
