package testTest;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome627 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int maxLength = 0;
        for(int i = 0;i <n;i++){
           if(map.containsKey(s.charAt(i))){
              map.replace(s.charAt(i), map.get(s.charAt(i))+1);
           }
           else{
              map.put(s.charAt(i),1);
           }
        }
        boolean singleExist = false;
        //不能在iterate map的时候remove
        for(Character key:map.keySet()){
            if(map.get(key) % 2 == 0){
               maxLength = maxLength + map.get(key);
               map.replace(key,0);
            }
            else{
                singleExist = true;
               maxLength = maxLength + map.get(key) - 1;
            }
        }
        if(singleExist){
           maxLength++;
        }      
        return  maxLength;
    }
}