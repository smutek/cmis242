package discussion;
/*
 * File: RobotWarrior.java
 * Author: Jimmy Smutek
 * Date: November 11, 2018
 * Purpose: Create Robot Warriors
 */


public class RobotWarrior {
  // The maximum number of people allowed to be converted to robots today
  private static final int MAX_PEOPLE = 2;
  // An array to hole new robots, initialized to the expected size for people
  private static String[] ROBOTS = new String[MAX_PEOPLE];

  /* Create Robot Squad :::: Method number 2.
   *
   * This method loops through the array of recruits and tries to add each of them to the robots
   * array. The robots array is initialized with a size of 2, and can only hold 2 people. Trying to
   * add too many items to the array will throw an out of bounds exception.
   *
   * It's not unusual for this type of error to occur in this particular scenario, so a try/catch
   * block is added here to check for array index out fo bounds exceptions. This is called a checked
   * exception.
   */
  private static void createRobotSquad(String[] recruits) {
    int i = 0;
    for (String recruit : recruits) {
      try {
        addToRobotSquad(recruit, i);
        i++;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println(
            "\n!!!ERROR!!!"
                + "\nArray Index Out of Bounds Exception while adding "
                + recruit
                + "."
                + "\nSpace only allocated for "
                + MAX_PEOPLE
                + " people, you are trying to add "
                + recruits.length
                + " people.\n");
      }
    }
  }


  /* Add To Robot Squad :::: Method number 3 / subordinate method to createRobotSquad()
   *
   * This method is subordinate to the createRobotSquad() method. addToRobotSquad loops through
   * the array of recruits and passes each recruit to this subordinate method, which then tries to
   * add the recruit to the robots array at the specified index.
   */
  private static void addToRobotSquad(String recruit, int index)
      throws ArrayIndexOutOfBoundsException {
    ROBOTS[index] = recruit;
  }

  /* Add To Robot Squad :::: Method number 3 / subordinate method to createRobotSquad()
   *
   *
   *
   */
  public static void main(String[] args) {

    // A group of 3 recruits to create a robot squad, but the array is only sized for 2
    String[] people = {"Bobo Jones", "Salvadore Bigmoney", "Stow Away"};

    // Output a greeting
    System.out.println("Welcome, robot recruits, creating Robot Squad.");

    // Start creating the robot squad.
    createRobotSquad(people);

    System.out.println("The following recruits were added to the Robot Squad:");
    for (String robot : ROBOTS) {
      System.out.println(robot);
    }
  }
}
