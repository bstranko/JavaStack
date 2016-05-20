/*
 * Author: Clifford A. Shaffer
 * Modified by: Bridgette Stranko
 * CSCI 315 - Data Structures
 * Program 3: Stacks
 */

/** Linked stack implementation */
public class LStack<E> implements StackADT<E> {

  private Link<E> top; // Pointer to first element
  private int size; // Number of elements

  /** Constructors */
  public LStack() { top = null; size = 0; }
  public LStack(int size) { top = null; size = 0; }

  /** Reinitialize stack */
  public void clear() { top = null; size = 0; }

  /** Put "it" on stack */
  public void push(E it) {
    top = new Link<E>(it, top);
    size++;
  }

  /** Remove "it" from stack */
  public E pop() {
    if(top == null) { return null; }
    else {
		 E it = top.element();
		 top = top.next();
		 size--;
		 return it;
	 }
  }

  /** @return Top value */
  public E peek() {
    if(top == null) { return null; }
    else{ return top.element(); }
  }

  /** @return Stack length */
  public int length() { return size; }
}


