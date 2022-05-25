package testTest;

public class MinimumASCIIDeleteSumForTwoStrings1076 {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: the lowest ASCII sum of deleted characters to make two strings equal
     */
    public int minimumDeleteSum(String s1, String s2) {
        // Write your code here
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        //dp[i][j] = min step of first i in s1 and first j in s2 
        for(int i = 1; i <= length1;i++){
           dp[i][0] = dp[i-1][0] + (int)s1.charAt(i-1);
        }
        for(int j = 1;j <= length2;j++){
           dp[0][j] = dp[0][j-1] + (int)s2.charAt(j-1);
        }
        for(int i = 1;i <= length1;i++){
            for(int j = 1;j <= length2;j++){
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                  dp[i][j] = dp[i-1][j-1];
               }
               else{
                   int a = dp[i][j-1] + (int)s2.charAt(j-1);
                   int b = dp[i-1][j] + (int)s1.charAt(i-1);
                   dp[i][j] = Math.min(a,b);
               }
            }
        }
        return dp[length1][length2];
    }
}
