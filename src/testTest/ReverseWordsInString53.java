package testTest;

import java.util.Stack;

public class ReverseWordsInString53 {
	public class Pair{
        int start;
        int end;
        public Pair(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public String reverseWords(String s) {
        if(allSpace(s)){
            return "";
        }
        Stack stack = helper(s);
        String result = "";
        if(stack.isEmpty()){
            return " ";
        }
        while(stack.size()>1){
          result = result + stack.pop() +" ";
        }
        result = result + stack.pop();
        return result;
    }

    private Stack helper(String s){
       Stack stack = new Stack();
       while(!allSpace(s)){
           Pair pair = firstIndexNotSpace(s);
           String word = s.substring(pair.start, pair.end);
           s = s.substring(pair.end);
           stack.push(word);
       }
       return stack;

    }

    private Pair firstIndexNotSpace(String s){
       int start = 0;
    
       while(start < s.length() && Character.isSpace(s.charAt(start))){
             start++;
       }
       int end = start;
       while(end < s.length() && !Character.isSpace(s.charAt(end))){
           end++;
       }
       Pair pair = new Pair(start,end);
       return pair;
    }

    private boolean allSpace(String s){
        if(s == null || s.isEmpty()){
           return true;
        }
        
        boolean a = false;
        int start = 0;
        while(start < s.length() && Character.isSpace(s.charAt(start))){
             start++;
        }
        if(start == s.length()){
           a = true;
        }
        return a;
    }
}
