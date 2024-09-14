package org.agcodes.designpatterns.strategy;

import java.util.Arrays;
import java.util.List;

public class ItemDataReader {

  public static List<ItemID> loadData(){
    return Arrays.asList(
        new ItemID(1,"Laptop",10000),
        new ItemID(2,"LCD",5000),
        new ItemID(3,"Keyboard",1000),
        new ItemID(5,"Mouse",100)
    );
  }

}
