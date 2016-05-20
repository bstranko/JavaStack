/*
 * Author: Bridgette Stranko
 * CSCI 315 - Data Structures
 * Program 3: Stacks
 */

public class DelimChecker {

  Boolean answer;

  //Constructor
  public DelimChecker( ){ Boolean answer = false; }

  public Boolean isLeft(char input){

    switch(input){

    case '{':
		answer = true;
		break;

    case '[':
      answer = true;
      break;

    case '(':
      answer = true;
      break;

    default:
      answer = false;
   }
    return answer;
  }

    public Boolean isLeft(char inputOne, char inputTwo){

      if(inputOne == '/' && inputTwo =='*')
        answer = true;
      else
        answer = false;

      return answer;
  }

  public Boolean isRight(char input){

    switch(input){

    case '}':
		answer = true;
		break;

    case ']':
      answer = true;
      break;

    case ')':
      answer = true;
      break;

    default:
      answer = false;
    }
    return answer;
  }

  public Boolean isRight(char inputOne, char inputTwo){

      if(inputOne == '*' && inputTwo == '/')
        answer = true;
      else
        answer = false;

      return answer;
  }

  public Boolean matches(char left, char right){
    switch(left){

    case '{':
		if ( right == '}')
		  answer = true;
		else
		  answer = false;
		break;

    case '[':
		if ( right == ']')
		  answer = true;
		else
		  answer = false;
      break;

    case '(':
		if ( right == ')')
		  answer = true;
		else
		  answer = false;
      break;

    case '/':
		if ( right == '/')
		  answer = true;
		else
		  answer = false;
      break;

    default:
      answer = false;

	  }
     return answer;
  }
}