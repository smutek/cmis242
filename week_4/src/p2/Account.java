package p2;
/*
 * File: Account.java
 * Author: Jimmy Smutek
 * Date: November 18, 2018
 * Purpose: Create and manage Account objects
 */

public class Account {

  // Accounts have a balance
  private double actBalance;
  // Accounts have a type
  private static final String[] ACT_TYPES = {"Checking", "Savings"};
  private int actType;
  // Service charge
  private static int withdraws;
  private static final int SER_CHARGE = 1;
  // Service charge threshold
  private static final int THRESHOLD = 3;

  /** Default Constructor */
  Account() {
    actBalance = 0; // zero balance
    actType = 0; // default to Checking
    withdraws = 0;
  }

  /**
   * Account Constructor
   *
   * @param actBalance double
   * @param actType int
   */
  Account(double actBalance, int actType) {
    this.actBalance = actBalance;
    this.actType = actType;
    withdraws = 0;
  }

  /*
   ********** Getters & Setters for Account Balance & Type
   */
  private double getActBalance() {
    return actBalance;
  }

  private void setActBalance(double actBalance) throws InsufficientFundsException {
    if (actBalance < 0) {
      throw new InsufficientFundsException("Insufficient Funds.");
    } else {
      this.actBalance = actBalance;
    }
  }

  int getActType() {
    return actType;
  }

  /**
   * To String
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Account{" + "actBalance=" + actBalance + ", actType=" + actType + '}';
  }

  String toDisplay() {
    return this.toString() + ",Type{" + ACT_TYPES[actType] + "}";
  }

  // Transaction methods
  // A withdraw request will need to include the amount and the target account
  // The withdraw will have to increment the service charge counter, then increment the withdraw
  // Amount accordingly.
  // The withdraw will then need to make sure there's enough money to cover the transaction.
  // The get balance method can be used for this.

  /**
   * Perform a balance check
   *
   * @return double
   */
  double balanceCheck() {
    return this.getActBalance();
  }

  /**
   * Deposit to an account
   *
   * @param amount double
   * @return String response message
   */
  String depositToAccount(double amount) {
    String response = "";
    try {
      this.setActBalance(this.getActBalance() + amount);
      response = "Deposit Successful.";
    } catch (InsufficientFundsException ex) {
      response = ex.getMessage();
    } finally {
      return response;
    }
  }

  /**
   * Withdraw from an account
   *
   * @param amount double
   * @return String response
   */
  String withdrawFromAccount(double amount) throws InsufficientFundsException {
    double current = this.getActBalance();
    double adjusted = current - amount;
    String response = null;

    if (!requiresServiceCharge()) {
      this.setActBalance(adjusted);
      response = "Transaction successful.";
      withdraws++;
    } else {
      this.setActBalance((adjusted - SER_CHARGE));
      response = "Transaction successful. Service charge added.";
      withdraws = 0;
    }
    return response;
  }

  /**
   * Account transfer
   * @param amount double
   * @param to Account
   * @return String response
   */
  String requestTransfer(double amount, Account to) {

    // Is the amount a multiple of 10?
    if (amount % 10 != 0) {
      return "Please enter a multiple of ten";
    }

    String response = "";
    // Try to remove the funds from this account
    double current = to.getActBalance();
    double adjusted = current - amount;

    try {
      to.setActBalance(adjusted);
    } catch (InsufficientFundsException m) {
      response = m.getMessage();
    } finally {
      try {
        this.setActBalance(this.getActBalance() + amount);
      } catch (InsufficientFundsException m) {
      response = m.getMessage();
      }
    }
    return response;
  }

  /**
   * Build response
   *
   * @param message String
   * @return String[]
   */
  String[] response(String message) {
    return new String[] {ACT_TYPES[this.getActType()], message};
  }

  /**
   * Check if a service charge is required
   *
   * @return boolean
   */
  private boolean requiresServiceCharge() {
    return ((withdraws + 1) >= THRESHOLD);
  }
}
