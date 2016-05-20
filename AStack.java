/*
 * Author: Clifford A. Shaffer
 * Modified by: Bridgette Stranko
 * CSCI 315 - Data Structures
 * Program 3: Stacks
 */

/** Array-based stack implementation */
@SuppressWarnings("unchecked") // Generic array allocation
class AStack<E> implements StackADT<E> {

  private static final int defaultSize = 10;
  private int maxSize; // Maximum size of stack
  private int top; // Index for top Object
  private E [] listArray; // Array holding stack
  private E [] tempArray; // Array holding stack

  /** Constructors */
  AStack() { this(defaultSize); }
    AStack(int size) {
    maxSize = size;
    top = 0;
    listArray = (E[])new Object[size]; // Create listArray
  }

  /** Reinitialize stack */
  public void clear() { top = 0; }

  /** Push "it" onto stack */
  public void push(E it) {
    if(top == maxSize) {
    	tempArray = (E[])new Object[top]; // Create listArray

      // Copies the elements from listArray into tempArray
      for (int i=0; i < listArray.length; i++) {
	 	  tempArray[i] = listArray[i];
	   }
      // Creates a new listArray that is twice the size of list array
	   listArray = (E[]) new Object [listArray.length*2];

	   // Copies the elements from the temp array into listArray
	 	for (int i = 0; i < tempArray.length; i++) {
		 	listArray[i] = tempArray[i];
	 	}
	}
  	listArray[top++] = it;

  }

  /** Remove and top element */
  public E pop() {
    if(top == 0) { return null; }
    else{ return listArray[--top]; }
  }

  /** @return Top element */
  public E peek() {
    if(top == 0) { return null; }
    else { return listArray[top-1]; }
  }

  /** @return Stack size */
  public int length() { return top; }
}


