package testTest;

public class MinimumPathSum110 {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
             return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int a = 1;a < n;a++){
          dp[0][a] = dp[0][a-1] + grid[0][a];
        }
        for(int b = 1;b < m;b++){
          dp[b][0] = dp[b-1][0] + grid[b][0];
        }

        for(int i = 1;i < m;i++){
            for(int k = 1;k < n;k++){
               dp[i][k] = Math.min(dp[i - 1][k],dp[i][k - 1]) + grid[i][k];
            }
        }
        return dp[m - 1][n - 1];
    }
}