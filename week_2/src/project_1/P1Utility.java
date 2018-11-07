package project_1;
/*
 * File: P1Utility.java
 * Author: Jimmy Smutek
 * Date: November 06, 2018
 * Purpose: Utility classes extracted from main
 */

import java.io.BufferedReader;
import java.io.IOException;

public class P1Utility {

  /**
   * Get Employees File Read in the employees file and return a tokenized array of strings.
   *
   * @param textFile String
   * @return String[][] Array of tokenized employee records
   */
  static String[][] getEmployeesFile(String textFile) {
    // Local method vars
    BufferedReader inputStream = null;
    String fileLine;
    String[][] fileLines = new String[P1Driver.MAX_RECORDS][P1Driver.TOTAL_FIELDS];
    String[][] returnLines;
    int i = 0;
    // Try to open the file
    try {
      // Create a buffered reader object
      inputStream = new BufferedReader(new java.io.FileReader(textFile));
      while ((fileLine = inputStream.readLine()) != null) {
        // Split the line by spaces into fields
        fileLines[i] = fileLine.split(" ");
        i++;
      }
      // Error handling for file read in
    } catch (IOException io) {
      System.out.println("There was a problem creating the BufferedReader. " + io.getMessage());
    } finally {
      // Try to close the open stream, if it exists
      try {
        if (inputStream != null) {
          inputStream.close();
        }
        // Error handling for stream close
      } catch (IOException io) {
        System.out.println("There was a problem closing the stream. " + io.getMessage());
      }
    }
    // Scale the array to correct size
    returnLines = new String[i][P1Driver.TOTAL_FIELDS];

    System.arraycopy(fileLines, 0, returnLines, 0, i);
    return returnLines;
  }

  /**
   * Create employee objects from Strings Takes an array of tokenized strings and returns employee
   * objects. Meant to be used in a loop.
   *
   * @param empString String[][]
   * @return Employee An employee object
   */
  static Employee createEmployeeObject(String[] empString) {

    // Create emp objects
    int year = Integer.parseInt(empString[P1Driver.YEAR_INDEX]);
    String title = empString[P1Driver.TITLE_INDEX];
    String name = empString[P1Driver.NAME_INDEX];
    int age = Integer.parseInt(empString[P1Driver.AGE_INDEX]);
    int salary = Integer.parseInt(empString[P1Driver.SALARY_INDEX]);

    Employee empObj = null;

    switch (title) {
      case "Executive":
        int stock = Integer.parseInt(empString[P1Driver.QUALIFIER_INDEX]);
        empObj = new Executive(name, age, salary, stock);
        break;
      case "Salesman":
        int sales = Integer.parseInt(empString[P1Driver.QUALIFIER_INDEX]);
        empObj = new Salesman(name, age, salary, sales);
        break;
      case "Employee":
        empObj = new Employee(name, age, salary);
    }
    return empObj;
  }

  /**
   * Increment year counter Increment the corresponding year counter. Used during file read in.
   *
   * @param year String
   */
  static void incrementYearCounter(String year) {
    if (year.equals("2016")) {
      P1Driver.total_2016++;
    } else {
      P1Driver.total_2017++;
    }
  }

  /**
   * Format employee info Nicer printed version of employee info.
   *
   * @param emp Employee object
   */
  static void displayInfo(Employee emp) {
    System.out.println("Name: " + emp.getEmpName());
    System.out.println("Title: " + emp.getClass());
    System.out.println("Age: " + emp.getEmpAge());
    System.out.println("Annual Salary: " + emp.annualSalary());
  }
}
