package testTest;

public class ClimbingStairsII272 {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;i < n+1;i++){
            int one = (i >= 1) ? dp[i-1]:0;
            int two = (i >= 2) ? dp[i-2]:0;
            int three = (i >= 3) ? dp[i-3]:0;
            dp[i] = one + two + three;
        }
        return dp[n];
    }
}
