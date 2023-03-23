/**
 * Import ArrayList utilities
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This class represents a stack data structure
 * @param <T> Generic data type in the stack, including
 *           integers, floats, chars, and strings, etc
 */
public class MyStack<T> {
    private final ArrayList<T> stack;

    public MyStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Push an element onto the stack
     * @param element An element to be pushed on to the stack
     */
    public void push(T element) {
        stack.add(element);
    }

    /**
     * Pop an element from the stack
     * @return the popped element, which used to be at the top of the list
     */
    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.remove(stack.size() - 1);
    }

    /**
     * Return the top element in the stack
     * @return the top element in the stack
     */
    public T top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.get(stack.size() - 1);
    }

    /**
     * Check if the stack is empty or not
     * @return True if the stack is empty, False otherwise
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    /**
     * Format a stack and produce a string representation
     * @return the string representation of a stack
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("Stack:");
        for (T element : stack)
            strBuilder.append(" ").append(element.toString());
        return strBuilder.toString();
    }
}
