package project_1;
/*
 * File: Executive.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Extends Employee
 */

public class Executive extends Employee {

  // Goal target and bonus
  private static final double BONUS = 45000.00;
  private static final double GOAL = 250.00;

  private double stockPrice;

  /**
   * Default Constructor
   */
  Executive() {
    stockPrice = 0;
  }

  /**
   * Constructor
   * @param empName String
   * @param empAge int
   * @param empMonthlySalary int
   * @param stockPrice int
   */
  Executive(String empName, int empAge, int empMonthlySalary, double stockPrice) {
    super(empName, empAge, empMonthlySalary);
    this.stockPrice = stockPrice;
  }

  /**
   * Calculate Executive bonus
   * @return int
   */
  int totalBonus() {
    if(this.stockPrice > GOAL)
      // return bonus as an int to conform to spec
      return (int) BONUS;
    return 0;
  }

  /**
   * Override for Annual salary
   * @return
   */
  @Override
  public int annualSalary() {
    return super.annualSalary() + this.totalBonus();
  }

  /**
   * To String
   * @return
   */
  @Override
  public String toString() {
    return "Executive{" + "stockPrice=" + stockPrice + ", " + super.toString() + '}';
  }

  // getters and setters

  /**
   * Get Stock price
   * @return double
   */
  double getStockPrice() {
    return stockPrice;
  }

  /**
   * Set stock price
   * @param stockPrice double
   */
  void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
  }
}
