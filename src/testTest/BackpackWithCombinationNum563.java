package testTest;

public class BackpackWithCombinationNum563 {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        //dp[i][j]表示在前i个数里凑出j的值的方法数量
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i = 1;i <= n; i++){
            for(int j = 0; j <= target; j++){
              if(j >= nums[i-1]){
            	  //取和不取的方法和 类似国际象棋那个问题 从不同的点跳过来
                 dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i-1]];
              }
              else{
                  dp[i][j] = dp[i-1][j];
              }
            }
        }
        return dp[n][target];
    }
}
