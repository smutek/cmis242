package project_1;
/*
 * File: Employee.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Create a default Employee object
 */
public class Employee {

  // Initialize Fields
  private String empName;
  private int empAge;
  // Salary to be specified in whole dollars, thus int is ok for data type
  private int empMonthlySalary;
  // @todo: ID is not in spec - add it if there is time
  // Default Constructor
  Employee() {
    empName = "Employee Name";
    empAge = 0;
    empMonthlySalary = 0;
  }
  // real constructor
  public Employee(String empName, int empAge, int empMonthlySalary) {
    this.empName = empName;
    this.empAge = empAge;
    this.empMonthlySalary = empMonthlySalary;
  }
  // Calculate monthly salary

  public int annualSalary() {
    // @todo: Needs error handling
    // Return employee monthly salary * 12
    return (this.empMonthlySalary) * 12;
  }

  // Getters and setters for Employee
  String getEmpName() {
    return empName;
  }

  void setEmpName(String empName) {
    this.empName = empName;
  }

  int getEmpAge() {
    return empAge;
  }

  void setEmpAge(int empAge) {
    this.empAge = empAge;
  }

  int getEmpMonthlySalary() {
    return empMonthlySalary;
  }

  void setEmpMonthlySalary(int empMonthlySalary) {
    this.empMonthlySalary = empMonthlySalary;
  }

  // to string
  @Override
  public String toString() {
    return "Employee{"
        + "empName='"
        + empName
        + '\''
        + ", empAge="
        + empAge
        + ", empMonthlySalary="
        + empMonthlySalary
        + '}';
  }
  // display method
  void display() {
    System.out.println(this.toString());
  }
}
