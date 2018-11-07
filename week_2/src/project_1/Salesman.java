package project_1;
/*
 * File: Salesman.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Creates a Salesman subclass object, extends Employee functionality
 */

public class Salesman extends Employee {

  // Goals to determine commission
  private static final int GOAL1 = 75;
  private static final int GOAL2 = 150;

  // Field for items sold
  private int itemsSold;
  private int totalCommission;

  /**
   * Default constructor
   */
  Salesman() {
    itemsSold = 0;
  }

  /**
   * Constructor
   * @param empName String
   * @param empAge int
   * @param empMonthlySalary int
   * @param itemsSold int
   */
  Salesman(String empName, int empAge, int empMonthlySalary, int itemsSold) {
    super(empName, empAge, empMonthlySalary);
    this.itemsSold = itemsSold;
  }

  /**
   * Calculate commission
   * @return int
   */
  private int calculateCommission() {
    if (this.itemsSold >= GOAL2) {
      return (this.getEmpMonthlySalary() * 2);
    } else if (this.itemsSold >= GOAL1) {
      return this.getEmpMonthlySalary();
    } else {
      return 0;
    }
  }

  /**
   * Salary override
   * @return
   */
  @Override
  public int annualSalary() {
    return (super.annualSalary() + this.calculateCommission());
  }

  /**
   * Get items sold
   * @return int items sold
   */
  public int getItemsSold() {
    return itemsSold;
  }

  /**
   * Set items sold
   * @param itemsSold int
   */
  public void setItemsSold(int itemsSold) {
    this.itemsSold = itemsSold;
  }

  /**
   * Get commission
   * @return int
   */
  public int getTotalCommissionAmount() {
    return this.calculateCommission();
  }

  /**
   * To string
   * @return
   */
  @Override
  public String toString() {
    return "Salesman{" + "itemsSold=" + itemsSold + ", " + super.toString() + '}';
  }
}
