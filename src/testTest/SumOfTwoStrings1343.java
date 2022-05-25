package testTest;

import java.util.Stack;

public class SumOfTwoStrings1343 {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return the sum of two strings
     */
    public String SumofTwoStrings(String A, String B) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        int lengthA = A.length();
        int lengthB = B.length();
        int pointerA = lengthA - 1;
        int pointerB = lengthB - 1;
        while(pointerA >= 0 && pointerB >= 0){
           int sum = Integer.parseInt(A.substring(pointerA,pointerA+1)) + Integer.parseInt(B.substring(pointerB,pointerB+1));
           stack.push(sum);
           pointerA--;
           pointerB--;
        }
        while(pointerA >= 0){
           stack.push(Integer.parseInt(A.substring(pointerA,pointerA+1)));
           pointerA--;
        }
        while(pointerB >= 0){
           stack.push(Integer.parseInt(B.substring(pointerB,pointerB+1)));
           pointerB--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String s = sb.toString();
        return s;
    }
}
