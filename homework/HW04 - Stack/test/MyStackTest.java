/**
 * Import JUnit test suite
 */
import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains all tests for the MyStack class
 */
public class MyStackTest {

    /**
     * Create test stacks
     */
    private MyStack stackTest = new MyStack<>();
    private MyStack emptyStack = new MyStack<>();

    /**
     * Fill a stack with elements
     */
    @Before
    public void stackSetUp() {
        stackTest.push(2);
        stackTest.push("Three");
        stackTest.push("4");
        stackTest.push(5.85);
        stackTest.push(10);
        stackTest.push("J");
        stackTest.push("Laura");
        stackTest.push(5);
    }

    /**
     * This test makes sure the newly created stacks
     * are instances of the MyStack class
     */
    @Test
    public void createStackTest() {
        MyStack newStack1 = new MyStack<>();
        MyStack newStack2 = new MyStack<>();
        MyStack newStack3 = new MyStack<>();

        assertTrue(newStack1 instanceof MyStack);
        assertTrue(newStack2 instanceof MyStack);
        assertTrue(newStack3 instanceof MyStack);
    }

    /**
     * This test makes sure the push method works by checking
     * the top-most element after every push
     */
    @Test
    public void pushTest() {
        stackTest.push(15);
        assertEquals(15, stackTest.top());

        stackTest.push("Elena");
        assertEquals("Elena", stackTest.top());

        stackTest.push(3.28);
        assertEquals(3.28, stackTest.top());
    }

    /**
     * This test makes sure the pop method works by checking
     * the top-most element after every pop
     */
    @Test
    public void popTest() {
        // Pop 5
        assertEquals(5, stackTest.pop());

        // Pop "Laura"
        assertEquals("Laura", stackTest.pop());

        // Pop "Jane"
        assertEquals("J", stackTest.pop());
    }

    /**
     * This test attempts to pop from an empty stack
     * Exception expected: EmptyStackException()
     */
    @Test (expected = EmptyStackException.class)
    public void popTestFail() {
        // Pop from empty stack
        emptyStack.pop();

        // Pop everything and more from stackTest
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
    }

    /**
     * This test makes sure the top element is correct
     * after each push or pop
     */
    @Test
    public void topTest() {
        // Check current stack
        assertEquals(5, stackTest.top());

        // Push new item
        stackTest.push("G");
        assertEquals("G", stackTest.top());

        // Pop an item
        stackTest.pop();
        stackTest.pop();
        assertEquals("Laura", stackTest.top());
    }

    /**
     * This test attempts to get a top element from an empty stack
     * Exception expected: EmptyStackException()
     */
    @Test (expected = EmptyStackException.class)
    public void topTestFail() {
        // Get the top element of an empty stack
        emptyStack.top();
    }

    /**
     * This test checks if the stack is empty
     */
    @Test
    public void emptyTest() {
        // Check existing empty stack
        assertTrue(emptyStack.empty());

        // Pop everything in a stack and then check
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();
        stackTest.pop();

        assertTrue(stackTest.empty());

        // Make sure a non-empty stack returns False
        stackTest.push("Test");
        assertFalse(stackTest.empty());
    }

    /**
     * This test makes sure the string representation
     * of stacks is correct
     */
    @Test
    public void stringTest() {
        // Empty stack
        assertEquals("Stack:", emptyStack.toString());

        // A filled stack
        assertEquals("Stack: 2 Three 4 5.85 10 J Laura 5",
            stackTest.toString());

        // Altered stack
        stackTest.pop();
        stackTest.pop();
        stackTest.push("Eli");
        assertEquals("Stack: 2 Three 4 5.85 10 J Eli",
            stackTest.toString());
    }
}
