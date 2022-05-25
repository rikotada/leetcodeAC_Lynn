package testTest;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            result.add(new ArrayList<>());
             return result;
        }
        dfs(s,0,new ArrayList<>());
        return result;
    }

    public void dfs(String s,int index,List<String> current){

        if(index == s.length()){
            result.add(new ArrayList<>(current));
        }
        for(int i = index + 1;i <= s.length();i++){
            if(isPalindrome(s.substring(index,i))){
                 current.add(s.substring(index,i));
                 dfs(s,i,current);
                 current.remove(current.size() - 1);
            }
        }
        return;
    }

    public boolean isPalindrome(String s){
       int len = s.length();
       int left = 0;
       int right = len - 1;
       while(left < right){
           if(s.charAt(left) != s.charAt(right)){
                return false;
           }
           left++;
           right--;
       }
       return true;
    }
}
