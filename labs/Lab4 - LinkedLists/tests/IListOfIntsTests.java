/**
 * Importing JUnit test suite
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IListOfIntsTests {

    // Init 3 types of list: full, partial, and empty
    IListOfInts listOfInts, partialListOfInts, emptyListOfInts;
    IListOfInts testEmptyList, testEmptyListAddFront, testEmptyListAddBack;

    /**
     * Create new lists for testing:
     * 1. An empty list
     * 2. A partially full list
     * 3. A full list
     */
    @Before
    public void listOfIntsSetUp() {

        emptyListOfInts = new EmptyNode();

        partialListOfInts = new ElementNode(1,
            new ElementNode(2,
                new ElementNode(3,
                    new ElementNode(4,
                        new EmptyNode()))));

        listOfInts = new ElementNode(5,
            new ElementNode(6,
                new ElementNode(7,
                    new ElementNode(8,
                        partialListOfInts))));
    }

    /**
     * Test if the count() function returns the correct number
     * of elements in an empty list, which is 0
     */
    @Test
    public void testCountEmpty() {
        assertEquals(0, emptyListOfInts.count());
    }

    /**
     * Test if the count() function returns the correct number
     * of elements in a partial list
     */
    @Test
    public void testCountPartial() {
        assertEquals(4, partialListOfInts.count());
    }

    /**
     * Test if the count() function returns the correct number
     * of elements in a full list
     */
    @Test
    public void testCountFull() {
        assertEquals(8, listOfInts.count());
    }

    /**
     * Test if the sum() function returns the correct sum
     * of elements in an empty list, which is 0
     */
    @Test
    public void sumEmpty() {
        assertEquals(0, emptyListOfInts.sum());
    }

    /**
     * Test if the sum() function returns the correct sum
     * of elements in a partial list
     */
    @Test
    public void sumPartial() {
        assertEquals(10, partialListOfInts.sum());
    }

    /**
     * Test if the sum() function returns the correct sum
     * of elements in a full list
     */
    @Test
    public void sumFull() {
        assertEquals(36, listOfInts.sum());
    }

    /**
     * Test if the getDataAtIndexFullTest() function
     * returns the correct element at the given index
     * in a full list
     */
    @Test
    public void getDataAtIndexFullTest() {
        assertEquals(8, listOfInts.getDataAtIndex(3));
    }

    /**
     * Test if the getDataAtIndexFullTest() function
     * returns the correct element at the given index
     * in a partial list
     */
    @Test
    public void getDataAtIndexPartialTest() {
        assertEquals(4, partialListOfInts.getDataAtIndex(3));
    }

    /**
     * Test if the getDataAtIndexFullTest() function
     * returns the correct element at the given index
     * in an empty list
     */
    @Test
    public void getDataAtIndexEmptyTest() {
        assertEquals(0, emptyListOfInts.getDataAtIndex(4));
    }


    /**
     * Test if addFront() function
     * correctly pushes data as new data is added
     * to a full list
     */
    @Test
    public void addFrontFullTest() {
        listOfInts.addFront(10);
        listOfInts.addFront(32);
        assertEquals(32, listOfInts.getDataAtIndex(0));
        assertEquals(10, listOfInts.getDataAtIndex(1));
        assertEquals(6, listOfInts.getDataAtIndex(3));
    }

    /**
     * Test if addFront() function
     * correctly pushes data as new data is added
     * to a partial list
     */
    @Test
    public void addFrontPartialTest() {
        partialListOfInts.addFront(10);
        partialListOfInts.addFront(32);
        assertEquals(32, partialListOfInts.getDataAtIndex(0));
        assertEquals(10, partialListOfInts.getDataAtIndex(1));
        assertEquals(2, partialListOfInts.getDataAtIndex(3));
    }

    /**
     * Test if getDataAtIndex() function
     * returns the correct data added to an empty list
     */
    @Test
    public void addFrontEmptyTest() {
        testEmptyListAddFront = new ElementNode(10, emptyListOfInts);
        emptyListOfInts.addFront(10);
        assertEquals("10", testEmptyListAddFront.toString());
    }

    /**
     * Test if addBack() function
     * correctly adds data to the back of a full list
     */
    @Test
    public void addBackFullTest() {
        listOfInts.addBack(15);
        listOfInts.addBack(24);
        assertEquals(24, listOfInts.getDataAtIndex(9));
    }

    /**
     * Test if addBack() function
     * correctly adds data to the back of a partial list
     */
    @Test
    public void addBackPartialTest() {
        partialListOfInts.addBack(15);
        partialListOfInts.addBack(24);
        assertEquals(24, partialListOfInts.getDataAtIndex(5));
    }

    /**
     * Test if addBack() function
     * correctly adds data to the back an empty list
     */
    @Test
    public void addBackEmptyTest() {
        testEmptyListAddBack = new EmptyNode().addFront(24);
        testEmptyListAddFront = new ElementNode(24, emptyListOfInts);
        emptyListOfInts.addBack(24);
        assertEquals("24", testEmptyListAddBack.toString());
    }

    /**
     * Test if the addAtIndex() function
     * returns the correct data added at a given index
     * in a full list
     */
    @Test
    public void addAtIndexFullTest() {
        listOfInts.addAtIndex(200, 5);
        assertEquals(200, listOfInts.getDataAtIndex(5));
        assertEquals(2, listOfInts.getDataAtIndex(6));
    }

    /**
     * Test if the addAtIndex() function
     * returns the correct data added at a given index
     * in a partial list
     */
    @Test
    public void addAtIndexPartialTest() {
        partialListOfInts.addAtIndex(30, 2);
        assertEquals(30, partialListOfInts.getDataAtIndex(2));
        assertEquals(3, partialListOfInts.getDataAtIndex(3));
    }

    /**
     * Test if the addAtIndex() function returns the correct value
     * at index 0 in an empty list
     */
    @Test
    public void addAtIndexEmptyTest() {
        testEmptyList = new ElementNode(15, emptyListOfInts);
        emptyListOfInts.addAtIndex(15, 0);
        assertEquals("15", testEmptyList.toString());
    }

    /**
     * Test if the addAtIndex() function will fail in an empty list
     * if an incorrect index is given
     */
    @Ignore ("Cannot add to an empty list at an index greater than 0")
    @Test
    public void addAtIndexEmptyTestFail() throws Exception {
        emptyListOfInts.addAtIndex(15, 1);
    }

    /**
     * Test if the toString() function
     * returns the correct string representation of
     * a full list
     */
    @Test
    public void toStringFullTest() {
        assertEquals("5 6 7 8 1 2 3 4", listOfInts.toString());
    }

    /**
     * Test if the toString() function
     * returns the correct string representation of
     * a partial list
     */
    @Test
    public void toStringPartialTest() {
        assertEquals("1 2 3 4", partialListOfInts.toString());
    }

    /**
     * Test if the toString() function
     * returns the correct string representation of
     * an empty list
     */
    @Test
    public void toStringEmptyTest() {
        assertEquals("", emptyListOfInts.toString());
    }
}