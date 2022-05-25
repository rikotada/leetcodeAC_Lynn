package testTest;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for(int i = 0;i < len;i++){
            if(!set.contains(tokens[i])){
                 stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int a = stack.pop();
                int b = stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(a + b);
                }
                else if(tokens[i].equals("-")){
                    stack.push(b - a);
                }
                else if(tokens[i].equals("*")){
                    stack.push(a * b);
                }
                else if(tokens[i].equals("/")){
                    stack.push(b / a);
                }
            }
        }
        return stack.peek();

    }
}
