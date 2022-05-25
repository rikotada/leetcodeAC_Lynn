package testTest;

public class ImplementThreeStacksBySingleArray224 {
    /*
    * @param size: An integer
    */
    public int[] arr;
    public int[] pointers;
    public ImplementThreeStacksBySingleArray224(int size) {
        // do intialization if necessary
        arr = new int[size * 3];
        pointers = new int[3];
        pointers[0] = 0;
        pointers[1] = 1;
        pointers[2] = 2;
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        // Push value into stackNum stack        
        arr[pointers[stackNum]] = value;
        pointers[stackNum] += 3;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        // Pop and return the top element from stackNum stack
        pointers[stackNum] -= 3;
        int result = arr[pointers[stackNum]];
        arr[pointers[stackNum]] = 0;
        
        return result;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        // Return the top element
        return arr[pointers[stackNum] - 3];
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        // write your code here
        return pointers[stackNum] == stackNum ? true : false;
    }
}
