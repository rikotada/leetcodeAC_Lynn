package testTest;

import java.util.Set;

public class WordBreak107 {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if(wordSet.size() == 0 && (s.equals("") || s == null)){
            return true;
        }
        if(wordSet.size() == 0){
            return false;
        }
        int maxWordLength = 0;
        for(String word:wordSet){
            maxWordLength = Math.max(maxWordLength,word.length());
        }
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i = 1;i < length+1;i++){
            for(int j = Math.max(i-maxWordLength,0); j < i;j++){
                if(!dp[j]){
                    continue;
                }
                String sub = s.substring(j,i);
                //前j个字符能拼&剩下的j-i在词典里
                if(wordSet.contains(sub) && dp[j]){
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
              
            }
        }
        return dp[length];
    }
}
