package arraystack;

import java.util.EmptyStackException;

/**
 * ArrayBasedStack Class
 * @author Navanit Krishna Satish Kumar
 * @version 10.03.2024
 * @param <T>
 */
public class ArrayBasedStack<T> implements StackADT<T> {
    private T[] stackArray;
    private int size;
    private int capacity;
    
    /**
     * Constructor for Array Based Stack
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack() {
        T[] tempbag = (T[]) new Object[100];
        stackArray = tempbag;
        size = 0;
        capacity = 100;
    }

    /**
     * Returns an array with a copy of each element in the stack with the top of
     * the stack being the last element
     *
     * @return the array representation of the stack
     */
    @Override
    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        T[] copy =   (T[]) new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }
    
    /**
     * Expands the capacity of the stack by doubling its current capacity.
    */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }
    
    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }
    
    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>) other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i])))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
     /**
      * @return true is stack is empty. false if not
      */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * @return item at the end of the stack
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stackArray[size - 1];
    }
    
    /**
     * item at the end of stack is removed
     * @return item that is removed
     */
    public T pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T value = this.stackArray[size - 1];
        this.stackArray[size - 1] = null;
        this.size--;
        return value;
    }
    
    /**
     * adds an item to the end of a stack
     *
     * @param item
     *            the item object is what needs to be added to the stack
     */
    @Override
    public void push(T item) {
        if (this.size == this.capacity) {
            this.expandCapacity();
        }
        this.stackArray[size] = item;
        this.size++;
    }
    
    /**
     * @return size of stack
     */
    public int size() {
        return size;
    }
    
    /**
     * Clears the stack
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        T[] newArray = (T[])new Object[this.capacity];
        this.stackArray = newArray;
        this.size = 0;
    }
    
    /**
     * checks if given item is present in the stack
     *
     * @param item
     *            item that is to be added
     *
     * @return true if item is in stack. false if item is not in stack or null
     */
    @Override
    public boolean contains(T item) {
        if (item == null) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (item.equals(this.stackArray[i])) {
                return true;
            }
        }
        return false;
    }
}
