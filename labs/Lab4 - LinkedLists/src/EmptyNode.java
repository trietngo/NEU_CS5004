/**
 * This represents an empty node in the list
 */

public class EmptyNode implements IListOfInts {

    /**
     * Add a node at the specified index
     * @param data an integer to be added
     * @param index an index to add the integer
     * @return an Element Node with data and the rest of the list
     * being this empty node
     */
    @Override
    public IListOfInts addAtIndex(int data, int index) {
        if (index > 0) {
            throw new IllegalArgumentException();
        }

        return new ElementNode(data, this);
    }

    /**
     * Add a node to the front of the empty list
     * @param data an integer
     * @return an element node with data and the rest of the list
     * being this empty node
     */
    @Override
    public IListOfInts addFront(int data) {
        return new ElementNode(data, this);
    }

    /**
     * Add a node to the back of the empty list, which is the
     * same as adding to the front
     * @param data an integer
     * @return an empty node with an Element Node in front
     */
    @Override
    public IListOfInts addBack(int data) {
        return new EmptyNode().addFront(data);
    }

    /**
     * Get data at index of an empty node, which is 0
     * @param index the index number in the list
     * @return 0, since this is an empty node
     */
    @Override
    public int getDataAtIndex(int index) {
        return 0;
    }

    /**
     * Get the count an empty node, which is 0
     * @return 0, since this is an empty node
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * Get the sum of an empty node, which is 0
     * @return 0, since this is an empty node
     */
    @Override
    public int sum() {
        return 0;
    }

    /**
     * Convert the empty node to a string, which is empty
     * @return empty string
     */
    @Override
    public String toString() {
        return "";
    }
}