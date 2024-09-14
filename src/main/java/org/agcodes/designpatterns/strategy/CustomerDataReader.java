package org.agcodes.designpatterns.strategy;


import static org.agcodes.designpatterns.strategy.Customer.CustomerCategory.*;
import java.util.Arrays;
import java.util.List;

public class CustomerDataReader {

  // Static method to load hardcoded data
public static List<Customer> loadData(){

  return Arrays.asList(
      new Customer(1,"Menna Yasser", SILVER),
      new Customer(2,"Dalia khalid", GOLD),
      new Customer(3,"Karim Omar", NEW),
      new Customer(4,"Mariam adel",null)

  );
}


}
