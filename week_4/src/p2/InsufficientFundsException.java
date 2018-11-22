package p2;
/*
 * File: InsufficientFundsException.java
 * Author: Jimmy Smutek
 * Date: November 19, 2018
 * Purpose: Checked exception class for account fund levels
 */

public class InsufficientFundsException extends Exception {

  public InsufficientFundsException() {}

  public InsufficientFundsException(String message) {
    super(message);
  }

  public InsufficientFundsException(String message, Throwable cause) {
    super(message, cause);
  }
}
