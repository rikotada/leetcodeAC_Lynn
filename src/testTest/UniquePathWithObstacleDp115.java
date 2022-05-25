package testTest;

public class UniquePathWithObstacleDp115 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int a = obstacleGrid.length;
        int b = obstacleGrid[0].length;
        if(a == 1 && b == 1){
          return 1;
        }
        int[][] dp = new int[a][b];
        int i = 0;
        int j = 0;
        //初始第一个格子和最后一个格子如果有障碍物就直接清零
        if(obstacleGrid[0][0] == 1 || obstacleGrid[a-1][b-1] == 1){
             return 0;
        }
        dp[0][0] = 1;
        for(i = 0;i < a;i++){
           for(j = 0;j < b;j++){
               //直接把边界情况给归进去了
               if(i>0 && obstacleGrid[i-1][j] == 0){
                 dp[i][j] = dp [i][j] + dp[i - 1][j];
               }
               if(j >0 && obstacleGrid[i][j-1] == 0){
                 dp[i][j] = dp [i][j] + dp[i][j-1];
               }
 
           }
        }
        return dp[a-1][b-1];
       }
}
