package arraystack;
import java.util.EmptyStackException;

/**
 * Test Cases for ArrayBasedStack
 * @author Navanit Krishna Satish Kumar
 * @version 10.03.2024
 */
public class ArrayBasedStackTest extends student.TestCase {
    private ArrayBasedStack<Integer> stackOne;
    private ArrayBasedStack<Integer> idenStack;
    private ArrayBasedStack<Integer> tripleStack;
    private ArrayBasedStack<Integer> otherStack;
    private ArrayBasedStack<Integer> nullStack;
    private ArrayBasedStack<Integer> emptyStack;
    private ArrayBasedStack<Integer> needExpand;
    
    /**
     * Setup to test the methods of ArrayBasedStack Class
     */
    public void setUp() {
        this.stackOne = new ArrayBasedStack<Integer>();
        this.idenStack = new ArrayBasedStack<Integer>();
        this.tripleStack = new ArrayBasedStack<Integer>();
        this.otherStack = new ArrayBasedStack<Integer>();
        this.nullStack = null;
        this.emptyStack = new ArrayBasedStack<Integer>();
        this.needExpand = new ArrayBasedStack<Integer>();
        

        for (int i = 0; i < 10; i++) {
            this.stackOne.push(i);
            this.idenStack.push(i);
            this.tripleStack.push(i * 3);
        }
        for (int i = 9; i >= 0; i--) {
            this.otherStack.push(i);
        }
        
    }
    
    /**
     * Tests expandCapacity method of ArrayBasedStack
     */
    public void testExpandCapacity() {
        for (int i = 0; i < 100; i++) {
            this.needExpand.push(i);
        }
        assertEquals(this.needExpand.size(), 100);
        needExpand.push(1);
        assertEquals(this.needExpand.size(), 101);
    }
    
    /**
     * Tests isEmpty method of ArrayBasedStack
     */
    public void testIsEmpty() {
        assertTrue(this.emptyStack.isEmpty());
        assertEquals(this.emptyStack.size(), 0, 0.01);
        this.emptyStack.push(1);
        assertFalse(this.emptyStack.isEmpty());
        assertEquals(this.emptyStack.size(), 1, 0.01);
    }
    
    /**
     * Tests peek method of ArrayBasedStack
     */
    public void testPeek() {
        assertTrue(this.stackOne.peek().equals(9));
        this.stackOne.pop();
        assertTrue(this.stackOne.peek().equals(8));
        Exception thrown = null;
        try {
            this.emptyStack.peek();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }
    
    /**
     * Tests pop method of ArrayBasedStack
     */
    public void testPop() {
        assertEquals(this.stackOne.size(), 10, 0.01);
        this.stackOne.pop();
        assertEquals(this.stackOne.size(), 9, 0.01);
        Exception thrown = null;
        try {
            this.emptyStack.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }
    
    /**
     * Tests push method of ArrayBasedStack
     */
    public void testPush() {
        boolean notAdded = false;
        assertEquals(this.emptyStack.size(), 0, 0.01);
        this.emptyStack.push(null);
    }
    
    /**
     * Tests contains method of ArrayBasedStack
     */
    public void testContains() {
        this.emptyStack.push(1);
        assertTrue(this.emptyStack.contains(1));
        assertFalse(this.emptyStack.contains(2));
        assertFalse(this.emptyStack.contains(null));
    }
    
    /**
     * Tests size method of ArrayBasedStack
     */
    public void testSize() {
        assertEquals(this.emptyStack.size(), 0, 0.01);
        assertEquals(this.stackOne.size(), 10, 0.01);
        this.emptyStack.push(1);
        assertEquals(this.emptyStack.size(), 1, 0.01);
    }
    
    /**
     * Tests clear method of ArrayBasedStack
     */
    public void testClear() {
        assertEquals(this.stackOne.size(), 10, 0.01);
        this.stackOne.clear();
        assertEquals(this.stackOne.size(), 0, 0.01);
        Exception thrown = null;
        try {
            this.stackOne.pop();
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof EmptyStackException);
    }
    
    /**
     * Tests toArray method of ArrayBasedStack
     */
    public void testToArray() {
        int[] toArrayTest = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Object[] stackOneToArray = stackOne.toArray();
        assertEquals(toArrayTest.length, stackOneToArray.length, 0.01);
        for (int i = 0; i < toArrayTest.length; i++) {
            assertEquals(toArrayTest[i], stackOneToArray[i]);
        }
    }
    
    /**
     * Tests toString method of ArrayBasedStack
     */
    public void testToString() {
        String toStringTest = "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String stackOneToString = stackOne.toString();
        assertEquals(toStringTest, stackOneToString);
        assertEquals(emptyStack.toString(), "[]");
    }
    
    /**
     * Tests equals method of ArrayBasedStack
     */
    public void testEquals() {
        assertTrue(this.stackOne.equals(this.stackOne));
        assertFalse(this.stackOne.equals(nullStack));
        assertFalse(this.stackOne.equals(""));
        assertFalse(this.stackOne.equals(this.emptyStack));
        assertFalse(this.tripleStack.equals(this.stackOne));
        assertFalse(this.stackOne.equals(this.otherStack));
        assertTrue(this.stackOne.equals(this.idenStack));
    }
}
