package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses780 {
    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0){
            result.add("");
              return result;
        }
        int pair = 0, left = 0, right = 0,usefulLeft = 0;
        int length = s.length();
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);          
            if(ch == '('){
               left++;
               usefulLeft++;
            }
            else if(ch == ')'){
               right++;
               if(usefulLeft > 0){
                  pair++;
                  usefulLeft--;
               }         
            }
        }
        if(pair == 0){
            s = s.replace("(", "");
            s = s.replace(")", "");
            result.add(s);
            return result;
        }
        dfs(s,new HashSet<>(),0,pair,0,0,"",result);
        return result;
    }

    public void dfs(String s,Set<String> set,int index,int pair,int addedLeft,int addedRight,String current,List<String> result){
        if(addedLeft > pair || addedRight > pair){
            return;
        }
        if(addedLeft == pair && addedRight == pair){
            String ss = new String(current);
            String tail = s.substring(index);
            tail = tail.replace("(", "");
            tail = tail.replace(")", "");
            ss = ss + tail;
            if(set.contains(ss)){
                return;
            }
            if(!isValid(ss,addedLeft)){
                return;
            }
            result.add(ss);
            set.add(ss);
            return;
        }
          int i = index;
          for(i = index;i < s.length();i++){
              char ch = s.charAt(i);
              if(ch == '(' || ch == ')'){
                break;
              }
          }
          if(i == s.length()){
              return;
          }
          else{
            char ch = s.charAt(i);
            if(ch == '('){
                dfs(s,set,i+1,pair,addedLeft,addedRight,current + s.substring(index, i),result);
                if(addedLeft + 1  <= pair){
                dfs(s,set,i+1,pair,addedLeft + 1,addedRight,current+s.substring(index, i+1),result);
                }            
            }
            else if(ch == ')'){
                dfs(s,set,i+1,pair,addedLeft,addedRight,current + s.substring(index, i),result);
                if(addedRight + 1  <= pair){
                dfs(s,set,i+1,pair,addedLeft,addedRight + 1,current+s.substring(index, i+1),result);
                }      
            }
          }
          
          return;

    }

    public boolean isValid(String s,int addedLeft){
        int pair = 0, usefulLeft = 0;
        int length = s.length();
        for(int i = 0;i < length;i++){
            char ch = s.charAt(i);          
            if(ch == '('){
               usefulLeft++;
            }
            else if(ch == ')'){
               if(usefulLeft > 0){
                  pair++;
                  usefulLeft--;
               }         
            }
        }
        return addedLeft == pair ? true : false;
    }


}
