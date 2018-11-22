package p2;
/*
 * File: Account.java
 * Author: Jimmy Smutek
 * Date: November 18, 2018
 * Purpose: Create and manage Account objects
 */

import java.text.NumberFormat;

public class Account {

  /*
  2. Class Account must have a constructor with one parameter representing the initial deposit
  plus four methods that correspond to each of the four buttons in the GUI.
  It must also incorporate logic to deduct a service charge of $1 when three total withdrawals
  are made from either account. Note that this means, for example, if one withdraw is made from
  the checking and one from the savings, any withdrawal from either account thereafter incurs the
  service charge. After the charge, the counter of withdrawals is reset.
  The methods that perform the withdrawals and transfers must throw an InsufficientFundsException
  exception whenever an attempt is made to withdraw or transfer more funds than are
  available in the account. Note that when service charges apply, there must also be sufficient
  funds to pay for that charge.
   */

  // Accounts have a balance
  private double actBalance;
  // Accounts have a type
  private static final String[] ACT_TYPES = {"Checking", "Savings"};
  private int actType;
  // Service charge
  private static int withdraws;
  private boolean chargesApply;
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

  private void setActBalance(double actBalance) {
    this.actBalance = actBalance;
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
    this.setActBalance(this.getActBalance() + amount);
    return "Deposit successful.";
  }

  /**
   * Withdraw from an account
   *
   * @param amount double
   * @return String response
   */
  String withdrawFromAccount(double amount) {
    double current = this.getActBalance();
    double adjusted = current - amount;
    String response = null;

    if (!requiresServiceCharge()) {
      this.setActBalance(adjusted);
      withdraws++;
      response = "No Service charge. ";
    } else {
      this.setActBalance((adjusted - SER_CHARGE));
      response = "Service charge added.";
      withdraws = 0;
    }
    return response;
  }

  String requestTransfer(double amount, Account to) {

    // Is the amount a multiple of 10?
    if (amount % 10 != 0) {
      return "Please enter a multiple of ten";
    }
    // Try to remove the funds from this account
    double current = to.getActBalance();
    double adjusted = current - amount;
    if (adjusted >= 0) {
      to.setActBalance(adjusted);
      this.setActBalance(this.getActBalance() + amount);
      return "Good to go";
    } else {
      return "lol";
    }
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
