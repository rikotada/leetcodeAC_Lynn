package testTest;

public class LongestPalindromicSubsequence667 {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n;i++){
            dp[i][i] = 1;
        }
        for(int j = 1; j < n;j++){
            for(int i = 0;i < n;i++){
                if(i + j >= n){
                    break;
                }
                if(s.charAt(i) != s.charAt(i+j)){
                    dp[i][i+j] = Math.max(dp[i+1][i+j],dp[i][i+j-1]);
                }
                else{
                    dp[i][i+j] = dp[i+1][i+j-1] + 2;
                }
            }
        }
        return dp[0][n-1];
        
    }

    
}