package testTest;

public class EditDistance119 {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int s1 = word1.length();
        int s2 = word2.length();
        int dp[][] = new int[s1+1][s2+1];
        int k = 1;
        for(k = 1;k < s1+1;k++){
            dp[k][0] = k;
        }
        for(k = 1;k < s2+1;k++){
            dp[0][k] = k;
        }
        for(int i = 1; i <= s1;i++){
            for(int j = 1;j < s2 + 1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                   
                }
                else{
                    dp[i][j] = Math.min(dp[i][j-1]+1,Math.min(dp[i-1][j]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[s1][s2];
    }
}
