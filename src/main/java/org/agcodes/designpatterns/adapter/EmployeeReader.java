package org.agcodes.designpatterns.adapter;

import java.util.Arrays;
import java.util.List;

public class EmployeeReader {

  public static List<NewEmployee> loadEmployeeData(){

    List<NewPayItem> payItemsAli = Arrays.asList(
        new NewPayItem("Salary", 5000, false),
        new NewPayItem("Transportation", 500, false),
        new NewPayItem("Health Insurance", 500, true)
    );

    List<NewPayItem> payItemMenna = Arrays.asList(
            new NewPayItem("Salary", 5000, false),
            new NewPayItem("Bonus", 500, false),
            new NewPayItem("Tax", 500, true)
    );

    List<NewPayItem> payItemsMariam = Arrays.asList(
        new NewPayItem("Salary", 5000, false),
        new NewPayItem("Loan Deduction", 300, true)
    );

    NewEmployee ali = new NewEmployee("Ali", "khalid",payItemsAli);
    NewEmployee menna = new NewEmployee("Menna", "yasser",payItemMenna);
    NewEmployee mariam = new NewEmployee("Mariam", "sameh",payItemsMariam);

    return Arrays.asList(ali,menna,mariam);

     };

}
