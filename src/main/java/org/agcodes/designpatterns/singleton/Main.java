package org.agcodes.designpatterns.singleton;

public class Main {

  public static void main(String[] args) {
    // Accessing the CurrencyConverter instance from multiple threads

    Runnable task1 = () -> {
      CurrencyConverter converter1  = CurrencyConverter.getInstance();
      System.out.println("Task1: " + converter1.convert("SAR","USD",20));
    };

    Runnable task2= ()->{
      CurrencyConverter converter2 = CurrencyConverter.getInstance();
      System.out.println("Task2: " + converter2.convert("SAR","EGP",100));
    };

    Thread thread1 = new Thread(task1);
    Thread thread2 = new Thread(task2);

    thread1.start();
    thread2.start();

  }

}
