/**
 * This interface represents all operations to be supported
 * by a list of integers
 */
public interface IListOfInts {

    /**
     * Add an integer to the list at a specified index
     * @param data an integer to be added
     * @param index an index to add the integer
     * @return
     */
    IListOfInts addAtIndex(int data, int index);

    /**
     * Add an integer to the front of the list
     * @param data an integer
     * @return
     */
    IListOfInts addFront(int data);

    /**
     * Add an integer to the back of the list
     * @param data an integer
     * @return
     */
    IListOfInts addBack(int data);

    /**
     * Return the data at a given index.
     * @param index the index number in the list
     * @return the data at that index
     */
    int getDataAtIndex(int index);

    /**
     * Count the number of integers in the list
     * @return the number of integers in the list
     */
    int count();

    /**
     * Calculate the sum of all integers in the list
     * @return sum of all integers in the list
     */
    int sum();

}
