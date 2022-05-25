package testTest;

public class BurstBalloons168 {
    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] a = new int[n+2];
        a[0] = 1;
        a[n+1] = 1; 
        for(int b = 1; b < n+1;b++){
          a[b] = nums[b-1];
        }
        int[][] dp = new int[n+2][n+2];
        int interval = 0;
        for(interval = 2;interval < n+2;interval++){
           for(int i = 0;i < n-interval+2; i++){
              int j = i+interval;
              dp[i][j] = Integer.MIN_VALUE;
              for(int k = i+1; k < j;k++){             
                  int point = a[i] * a[j] * a[k];
                  if(dp[i][k]+dp[k][j]+point > dp[i][j]){
                   dp[i][j] = dp[i][k]+dp[k][j]+point;
                   }
              }
           }
        }
        return dp[0][n+1];
    }
}
