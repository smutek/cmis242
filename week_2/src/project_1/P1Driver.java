package project_1;
/*
 * File: P1Driver.java
 * Author: Jimmy Smutek
 * Date: November 04, 2018
 * Purpose: Provides the main program method
 */

public class P1Driver {
  // Static variables and constants
  // @todo: Write a proper file loader
  static final String FILE = "./week_2/src/project_1/data/inputData.txt";
  static final int MAX_RECORDS = 500;
  static final int TOTAL_FIELDS = 5;
  static final String[] AVAILABLE_YEARS = {"2016", "2017"};
  static int total_records = 0;
  static int total_2016 = 0;
  static int total_2017 = 0;
  // Array key indexes.
  static final int YEAR_INDEX = 0;
  static final int TITLE_INDEX = 1;
  static final int NAME_INDEX = 2;
  static final int AGE_INDEX = 3;
  static final int SALARY_INDEX = 4;
  static final int QUALIFIER_INDEX = 5;
  // For console output
  static final String SPACE = "************************\n";
  static final String SPACIER = "***************************************\n";

  /**
   * Main Method
   *
   * @param args
   */
  public static void main(String[] args) {

    // Read in file contents
    String[][] fileContents = P1Utility.getEmployeesFile(FILE);
    total_records = fileContents.length;
    Employee[] employees = new Employee[total_records];
    int i = 0, j = 0, k = 0;

    // Create employee objects
    for (String[] fileLine : fileContents) {
      employees[i] = P1Utility.createEmployeeObject(fileLine);
      P1Utility.incrementYearCounter(fileLine[YEAR_INDEX]);
      i++;
    }

    // Sort employees
    Employee[] group2016 = new Employee[total_2016];
    Employee[] group2017 = new Employee[total_2017];
    Employee[][] groups = {group2016, group2017};

    // Create arrays of employee objects
    i = 0;
    for (String[] line : fileContents) {
      if (line[YEAR_INDEX].equals("2016")) {
        group2016[j] = employees[i];
        j++;
      } else {
        group2017[k] = employees[i];
        k++;
      }
      i++;
    }

    System.out.println("Employee Report\n");
    i = 0;
    int highest = 0;
    int totalSalaries = 0;
    double averageSalry = 0;
    String highestPaid = null;
    for (Employee[] empgroup : groups) {
      int[] salaries = new int[empgroup.length];
      System.out.println(AVAILABLE_YEARS[i]);
      System.out.println(SPACIER);
      for (Employee emp : empgroup) {
        P1Utility.displayInfo(emp);
        System.out.println(SPACE + "\n");
        int salary = emp.getEmpMonthlySalary();
        salaries[i] = salary;
        totalSalaries = (totalSalaries + salary);
        if (salary > highest) {
          highest = salary;
          highestPaid = emp.getEmpName();
        }
      }
      System.out.println("Totals for " + AVAILABLE_YEARS[i] + ":");
      System.out.println("Total Employees: " + groups[i].length);
      System.out.println("Average salary: " + (totalSalaries / salaries.length));
      System.out.println("Highest Paid: " + highestPaid);

      i++;
    }
  }
}
