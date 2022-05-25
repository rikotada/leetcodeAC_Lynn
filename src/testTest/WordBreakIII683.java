package testTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;
public class WordBreakIII683 {
    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        if(dict.size() == 0 || s == null || s.length() == 0){
             return 0;
        }
        int n = s.length();
        String sLower = s.toLowerCase();
        Set<String> lower = new HashSet<>();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for(String word:dict){
             lower.add(word.toLowerCase());
             int length = word.length();
             if(length < minLength){
                minLength = length;
             }
             if(length > maxLength){
                maxLength = length;
             }
        }
        for(int i = 1;i < n + 1;i++){
            int get = 0;
            if(i < minLength){
              continue;
            }
            for(int j = minLength; j<= Math.min(maxLength,i);j++){
                if(dp[i-j] > 0 && lower.contains(sLower.substring(i-j,i))){
                     get = get + dp[i-j];
                }
            }
            dp[i] = get;
        }
        
        return dp[n];

    }
}
