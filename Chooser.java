/*
 * Author: Bridgette Stranko
 * CSCI 315 - Data Structures
 * Program 3: Stacks
 */

import java.util.Scanner;	// Needed for Scanner class

public class Chooser {

  private String input; // To hold user input
  private char answer;  // to hold converted input
  private char cAnswer;  // To hold converted char type answer
  private Boolean bAnswer; // To hold Boolean type answers
  private Scanner keyboard = new Scanner(System.in);

  //Constructor
  public Chooser(){ }

  public char stackType(){
    do {
	   System.out.println("\nDo you want to run the program with");
      System.out.println("A) an array-based list or");
      System.out.println("L) a linked-based list");
      System.out.println("S) a Java Stack adapted list");
      System.out.print("\n[USER]: ");

      input = keyboard.nextLine();  // Get user input
      input = input.toUpperCase();  // Change to upper case
      cAnswer = input.charAt(0);  // Get first character

      if (cAnswer != 'A' && cAnswer != 'L' && cAnswer != 'S') {
        System.out.println("That is not a valid option. Try again.");
	   }
    } while(cAnswer != 'A' && cAnswer!= 'L' && cAnswer != 'S');

    return cAnswer;
  }

  public Boolean runAgain() {
	 do {
	   System.out.println("\nDo you want to run the program again?");
      System.out.println("Enter 'Y' to run again or");
      System.out.println("N to quit.");
      System.out.print("\n[USER]: ");

      input = keyboard.nextLine();  // Get user input
	   input = input.toUpperCase();  // Change to upper case
	   answer = input.charAt(0);  // Get first character

	   if (answer == 'Y') { bAnswer = true; }
	   else if (answer == 'N') { bAnswer = false; }
	   else {
	         System.out.println("That is not a valid option. Try again.");
	 	   }
    } while(answer != 'Y' && answer!= 'N');
    return bAnswer;
  }
}