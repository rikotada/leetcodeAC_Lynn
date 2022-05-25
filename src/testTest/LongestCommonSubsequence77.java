package testTest;

public class LongestCommonSubsequence77 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int a = A.length();
        int b = B.length();
        int[][] dp = new int[a+1][b+1];
        for(int i = 1;i < a+1;i++){
            for(int j = 1;j < b+1;j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                	//选上i和j
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                	//要么选i 要么选j
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[a][b];
    }
}
