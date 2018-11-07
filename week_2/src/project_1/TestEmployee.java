package project_1;
/*
 * File: TestEmployee.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Test driver for the Employee object
 */

public class TestEmployee {
  // Spacer for console output
  private static void sectionSpacer() {
    System.out.println("\n**********");
  }

  public static void main(String[] args) {
    System.out.println("Employee superclass & subclass test driver ******");
    sectionSpacer();
    /*
     ********** Testing the default constructor.
     */
    // Test default constructor
    System.out.println("Default Constructor");
    Employee emp1 = new Employee();
    // Should output base employee field values
    emp1.display();
    System.out.println("annualSalary(): " + emp1.annualSalary());
    /*
     ********** Testing a custom Employee constructor.
     */
    // Constructor
    sectionSpacer();
    System.out.println("Test creating an Employee");
    Employee emp2 = new Employee("Human Bob", 33, 1000);
    emp2.display();
    // Test Getters
    sectionSpacer();
    System.out.println("Testing getters");
    System.out.println("getEmpName(): " + emp2.getEmpName());
    System.out.println("getEmpAge(): " + emp2.getEmpAge());
    System.out.println("getEmpMonthlySalary(): " + emp2.getEmpMonthlySalary());
    System.out.println("annualSalary(): " + emp2.annualSalary());
    // Test Setters
    sectionSpacer();
    System.out.println("Test setting: name = Radical Rosie, age = 26, monthly = 2000");
    emp2.setEmpName("Radical Rosie");
    emp2.setEmpAge(26);
    emp2.setEmpMonthlySalary(2000);
    System.out.println("Values set, result:");
    emp2.display();
    System.out.println("annualSalary(): " + emp2.annualSalary());
    /*
     ********** Testing a default Salesman constructor.
     */
    sectionSpacer();
    Salesman salesman1 = new Salesman();
    System.out.println("Default Salesman");
    salesman1.display();
    /*
     ********** Testing a custom Salesman constructor.
     */
    sectionSpacer();
    System.out.println("Custom Salesman");
    Salesman salesman2 = new Salesman("Salesman Sally", 22, 500, 64);
    salesman2.display();
    System.out.println(
        "Annual salary after commission adjustment:"
            + "Items sold = 64, Salary should remain at 6000");
    sectionSpacer();
    // Getters
    System.out.println("getEmpName(): " + salesman2.getEmpName());
    System.out.println("getEmpAge(): " + salesman2.getEmpAge());
    System.out.println("getEmpMonthlySalary(): " + salesman2.getEmpMonthlySalary());
    System.out.println("annualSalary(): " + salesman2.annualSalary());
    // Setters
    sectionSpacer();
    System.out.println("Testing Setters");
    System.out.println(
        "Test setting: name = Saleswoman Sally, age = 21, monthly = 1000, sold = 150");
    salesman2.setEmpName("Saleswoman Sally");
    salesman2.setEmpAge(21);
    salesman2.setEmpMonthlySalary(1000);
    salesman2.setItemsSold(150);
    System.out.println("updated toString:");
    salesman2.display();
    System.out.println("Updated getters & annual salary");
    System.out.println("getEmpName(): " + salesman2.getEmpName());
    System.out.println("getEmpAge(): " + salesman2.getEmpAge());
    System.out.println("getEmpMonthlySalary(): " + salesman2.getEmpMonthlySalary());
    System.out.println("annualSalary(): " + salesman2.annualSalary());
    /*
     ********** Testing a default Executive constructor.
     */
    sectionSpacer();
    Executive exec1 = new Executive();
    System.out.println("Default Executive");
    exec1.display();
    /*
     ********** Testing a custom Executive constructor.
     */
    sectionSpacer();
    Executive exec2 = new Executive("Rocky", 26, 10000, 250.00);
    System.out.println("Custom Executive");
    exec2.display();
    // Getters
    System.out.println("getEmpName(): " + exec2.getEmpName());
    System.out.println("getEmpAge(): " + exec2.getEmpAge());
    System.out.println("getEmpMonthlySalary(): " + exec2.getEmpMonthlySalary());
    System.out.println("totalBonus(): " + exec2.totalBonus());
    System.out.println("getStockPrice(): " + exec2.getStockPrice());
    System.out.println("annualSalary(): " + exec2.annualSalary());
    sectionSpacer();
    // Setters
    exec2.setEmpName("Mugsy");
    exec2.setEmpAge(57);
    exec2.setEmpMonthlySalary(50000);
    exec2.setStockPrice(250.000000001);
    System.out.println("Setters");
    exec2.display();
    System.out.println("getEmpName(): " + exec2.getEmpName());
    System.out.println("getEmpAge(): " + exec2.getEmpAge());
    System.out.println("getEmpMonthlySalary(): " + exec2.getEmpMonthlySalary());
    System.out.println("totalBonus(): " + exec2.totalBonus());
    System.out.println("getStockPrice(): " + exec2.getStockPrice());
    System.out.println("annualSalary(): " + exec2.annualSalary());
  }
}
