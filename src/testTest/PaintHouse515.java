package testTest;

public class PaintHouse515 {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if(costs == null || costs.length == 0){
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[3][n];
        dp[0][0] = costs[0][0];
        dp[1][0] = costs[0][1];
        dp[2][0] = costs[0][2];
        for(int i = 1;i < n;i++){
            for(int j = 0;j < 3;j++){
                 int previous  = Math.min(dp[(j+1)%3][i-1],dp[(j+2)%3][i-1]);
                 dp[j][i] = previous + costs[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0;i < 3;i++){
           result = Math.min(result,dp[i][n-1]);
        }
        return result;
    }
}
