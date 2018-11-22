package p2;
/*
 * File: TestAccount.java
 * Author: Jimmy Smutek
 * Date: November 21, 2018
 * Purpose: Test account class
 */

public class TestAccount {
  public static void main(String[] args) {

    // Test default account Constructor
    Account testDefault = new Account();
    System.out.println(testDefault.toString());

    // Test custom account Constructor
    Account testCustom = new Account(1000000,1);
    System.out.println(testCustom.toDisplay());
  }
}
