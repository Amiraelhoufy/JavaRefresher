package org.agcodes.designpatterns.singleton;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

  // 1- create private static volatile instance of the class
  private static volatile CurrencyConverter instance;

  // 2- create currency exchange rate
  Map<String,Double> currencyRate;

  // 3- private constructor to prevent instantiation from outside the class
  private CurrencyConverter(){
    currencyRate = new HashMap<>();
    // Initializing some conversion rates
    currencyRate.put("USD_TO_SAR",3.75);
    currencyRate.put("SAR_TO_USD",0.27);
    currencyRate.put("EGP_TO_SAR",0.078);
    currencyRate.put("SAR_TO_EGP",12.89);
  }
  // 4- Encapsulation for the instance - Thread safe with double checked locking
  public static CurrencyConverter getInstance(){
    // To prevent Null instance exception
    // 1st check for performance
    if(instance ==null){
      synchronized (CurrencyConverter.class){
        // 2nd check
        // to check if another thread initialized the instance between 1st check and acquiring the lock
        if(instance == null){
          instance = new CurrencyConverter();
        }
      }
    }
    return instance;
  }

  // Method to add or update exchange rates
  public void setExchangeRate(String currencyPair,double rate){
      currencyRate.put(currencyPair,rate);
  };

  // Method to convert currencies
  public double convert(String currencyFrom, String currencyTo, double amount){
    String key = currencyFrom.toUpperCase() + "_TO_" + currencyTo.toUpperCase();
    if(currencyRate.containsKey(key)){

      return amount * currencyRate.get(key);

    }else{
      throw new IllegalArgumentException("No currency exchange rate was found for converting: " + key);
    }

  }


}
