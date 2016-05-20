/*
 * Author: Bridgette Stranko
 * CSCI 315 - Data Structures
 * Program 3: Stacks
 */

/** Stack Adapter Class*/
@SuppressWarnings("unchecked")
public class StackAdapter<E>
         implements StackADT<E>{
  private java.util.Stack javaStack;
  private int size; // Number of elements

  /**Constructor*/
  public StackAdapter(){
    javaStack = new java.util.Stack();
    size = 0;
  }

  /** Reinitialize stack */
  public void clear() {
    javaStack.empty();
    size = 0;
  }

  /** Push "it" onto stack */
  public void push(E it) {
    javaStack.push(it);
    size++;
  }

  /** Remove and top element */
  public E pop() {
    E it = (E)javaStack.pop();
    size--;
    return it;
  }

  /** @return Top element */
  public E peek() {
    E it = (E)javaStack.peek();
    return it;
  }

  /** @return Stack size */
  public int length() { return size; }
}
