/*
* Author: Bridgette Stranko
* CSCI 315 - Data Structures
* Program 3: Stacks
*/
import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class mainDelimChecker {

	public static void main (String[] args) throws IOException{

		String fileLine;
		char fileChar, choice, leftDelim, rightDelim;
		int lineNum = 0;
		final int STACK_SIZE = 25;
		Boolean error, ignore = false;

		StackADT<Character> charStack = new LStack();
		StackADT<Integer>  numStack = new LStack();
		DelimChecker checker = new DelimChecker();
		Chooser userChoice = new Chooser();

		System.out.println("Welcome to the program. Before you start ");
		System.out.print("make sure you have a java file in the program ");
		System.out.print("folder. It must be name testProgram.java");

		do
		{
			choice = userChoice.stackType();
			if(choice == 'A') {
				charStack = new AStack(STACK_SIZE);
				numStack = new AStack(STACK_SIZE);
			}

			else if(choice == 'S') {
				charStack = new LStack(STACK_SIZE);
				numStack = new LStack(STACK_SIZE);
			}

			//else don't do anything. Had to initialize stack.
			//Chose Link based list. If not A or S, then must be L

			File testFile = new File("testProgram.java");

			if(!testFile.exists()) {
				System.out.println("File not found");
			}else {
				Scanner inputFile = new Scanner(testFile);
				error = false;
				lineNum = 0;
				ignore = false;

				while(inputFile.hasNext()) {
					fileLine = inputFile.nextLine();
					lineNum++;

					for( int i = 0; i < fileLine.length() && ignore == false; i++ ){
						fileChar = fileLine.charAt(i);
						if(fileChar == '/' && i < fileLine.length()-1) {
							if ( fileLine.charAt(i+1) == '*') {
								charStack.push(fileChar);
								numStack.push(lineNum);
							} else if ( fileLine.charAt(i+1) == '/') {
								ignore = true;
							}
						} else if(fileChar == '/' && i > 0) {
							if (fileLine.charAt(i-1) == '*') {
								if (charStack.peek() == null) {
									System.out.println("There is no matching delimiter for *" + fileChar + " on line " + lineNum);
									error = true;
								} else if (checker.matches(charStack.peek(), fileChar)) {
									charStack.pop();
									numStack.pop();
								} else {
									System.out.println("There is no matching delimiter for *" + fileChar + " on line " + lineNum);
									error = true;
								}
							}
						} else if(checker.isLeft(fileChar)) {
							charStack.push(fileChar);
							numStack.push(lineNum);
						} else if(checker.isRight(fileChar)) {
							if(charStack.peek() == null) {
								System.out.println("There is no matching delimiter for " + fileChar + " on line " + lineNum);
								error = true;
							} else {
								leftDelim = charStack.peek();
								if(checker.matches(leftDelim, fileChar)) {
									charStack.pop();
									numStack.pop();
								} else {
									System.out.println(fileChar + " on line number: " + lineNum + " produced an error because it didn't match " + charStack.pop());
									numStack.pop();
									error = true;
								}
							}
						}
					}
				}
				inputFile.close();

				if (charStack.length() > 0) {
					error = true;
					while(charStack.length() > 0) {
						if(charStack.peek() == '/') {
							System.out.println("No matching delimiter for " + charStack.pop() + "* on line " + numStack.pop());
						} else {
							System.out.println("No matching delimiter for " + charStack.pop() + " on line " + numStack.pop());
						}
					}
				}
				if (error == true) {
					System.out.println("The delimiters in your file are not balanced.");
				} else {
					System.out.println("The delimiters in your file are balanced.");
				}
			}
		}while(userChoice.runAgain());
	}
}
/*-----------------------------------------------------------------
Welcome to the program. Before you start
make sure you have a java file in the program folder. It must be name testProgram.java
Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: a
} on line number: 1 produced an error because it didn't match [
) on line number: 1 produced an error because it didn't match {
There is no matching delimiter for ] on line 1
The delimiters in your file are not balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: l
The delimiters in your file are balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: s
The delimiters in your file are balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: n
Press any key to continue . . .
-------------------------------------------------------*/

/* -------------------------------------------------------
Test run 2:

Welcome to the program. Before you start
make sure you have a java file in the program folder. It must be name testProgra
m.java
Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: a
The delimiters in your file are balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: l
No matching delimiter for /* on line 1
The delimiters in your file are not balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: s
} on line number: 2 produced an error because it didn't match (
] on line number: 3 produced an error because it didn't match {
) on line number: 4 produced an error because it didn't match [
The delimiters in your file are not balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: n
Press any key to continue . . .

-----------------------------------------------------------------*/

/* -------------------------------------------------------------
test run 3
Welcome to the program. Before you start
make sure you have a java file in the program folder. It must be name testProgra
m.java
Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: a
There is no matching delimiter for } on line 2
The delimiters in your file are not balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: l
] on line number: 5 produced an error because it didn't match {
The delimiters in your file are not balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: s
The delimiters in your file are balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: n
Press any key to continue . . .
----------------------------------------------------------------*/
/*---------------------------------------------------------------
Test Run 4

Welcome to the program. Before you start
make sure you have a java file in the program folder. It must be name testProgra
m.java
Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: a
The delimiters in your file are balanced.

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: y

Do you want to run the program with
A) an array-based list or
L) a linked-based list
S) a Java Stack adapted list

[USER]: a
File not found

Do you want to run the program again?
Enter 'Y' to run again or
N to quit.

[USER]: n
Press any key to continue . . .

-------------------------------------------------------------*/
/* test cases is order:
test case#1
{[})]
test case#2
{}[]()
test case#3
[{}()]
test case#4
/[{}()]
test case#5
/*[{}()]
test case#6
[{(
   }
     ]
)
test case#7
[{}()]
}
test case#8
public class LinkedStack<T>{
   private T[] data;
   public LinkedStack<T>(int size){
      data = new T[size];
   ]
}
test case#9
myStack = new LinkedListStack(); //comment this line out to change types :)
test case#10
/*[{}()]*/

/*
test case#11
no file
*/