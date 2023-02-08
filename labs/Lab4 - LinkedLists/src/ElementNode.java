/**
 * This represents a non-empty node in the list
 * It contains an integer and a pointer to next node
 */

public class ElementNode implements IListOfInts {
    private int integer;
    private IListOfInts rest;

    /**
     * Construct a node with data
     * @param data integer of a node
     * @param rest the rest of the linked list
     */
    public ElementNode(int data, IListOfInts rest) {
        this.integer = data;
        this.rest = rest;
    }

    /**
     * Add a new value at the specified index
     * @param data an integer to be added
     * @param index an index to add the integer
     * @return
     */
    @Override
    public IListOfInts addAtIndex(int data, int index) {
        // Base case:
        // If the index is 0, then data should be added to the
        // front of the list
        if (index == 0) {
            return this.addFront(data);
        }

        // Recursive case:
        // Recursively shift the rest of the list towards the first index
        this.rest = this.rest.addAtIndex(data, index - 1);
        return this;
    }

    /**
     * Add an element to the front of the list
     * @param data an integer
     * @return the new node added to the front
     */
    @Override
    public IListOfInts addFront(int data) {
        // Convert the rest of the list into a new Element Node
        // with a duplicate first element
        this.rest = new ElementNode(this.integer, this.rest);

        // Set the new value for the first element
        this.integer = data;
        return this;
    }

    /**
     * Add an element to the back of the list
     * @param data an integer
     * @return the new node added to the back
     */
    @Override
    public IListOfInts addBack(int data) {
        // Set the rest of the list
        this.rest = this.rest.addBack(data);
        return this;
    }

    /**
     * Get the data at a given index
     * @param index the index number in the list
     * @return the data at the specified index, recursively
     */
    @Override
    public int getDataAtIndex(int index) {
        // Base case:
        // If the index is 0 (front of list),
        // Returns the first node's data
        if (index == 0) {
            return this.integer;
        }

        // Recursive case:
        // Recursively shift the rest of the list towards the first index
        return this.rest.getDataAtIndex(index - 1);
    }

    /**
     * Count the number of items in the list
     * @return the number of items in the list
     */
    @Override
    public int count() {
        // Total number of items in the list equals
        // the number of items in the rest of the list plus 1
        // 1 being the first element
        return this.rest.count() + 1;
    }

    /**
     * Compute the sum of all elements in the list
     * @return the sum of all elements in the list
     */
    @Override
    public int sum() {
        // The sum of all items in the list equals
        // the sum of all items in the rest of the list plus
        // the number of the first element
        return this.rest.sum() + this.integer;
    }

    /**
     * Convert the linked list into a string
     * @return the linked list as a string
     */
    public String toString() {
        // The first element of the list
        String intString = String.format("%d", this.integer);

        // The rest of the list
        String rest = this.rest.toString();

        // If the length of the rest is at least 1
        if (rest.length() > 0) {
            // Concatenate
            return intString + " " + rest;
        }

        // Otherwise return the first item as a string
        return intString;
    }

}