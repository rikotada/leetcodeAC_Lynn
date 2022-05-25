package testTest;

public class StoneGameII593 {
    /**
     * @param A: An integer array
     * @return: An integer
     */
    public int stoneGame2(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len * 2][len * 2];
        int[] prefix = new int[len * 2 + 1];
        for(int i = 1;i <= len;i++){
           prefix[i] = A[i - 1] + prefix[i - 1]; 
        }
        for(int n = len + 1;n <= len * 2;n++){
           prefix[n] = A[n - 1 - len] + prefix[n - 1];
        }
        for(int interval = 1;interval < len;interval++){
            
            for(int index = 0; index < len * 2;index++){
               int step = Integer.MAX_VALUE;
               if(interval + index >= 2 * len){
                   continue;
               }
               for(int m = index; m < interval + index;m++){
                   step = Math.min(dp[index][m] + dp[m + 1][interval + index],step);
               }
               if(step == Integer.MAX_VALUE){
                    step = 0;
               }
               dp[index][interval + index] = step + prefix[interval + index + 1] - prefix[index];
              
            }
        }
        int result = Integer.MAX_VALUE;
        for(int p = 0;p < len;p++){
             result = Math.min(result,dp[p][p + len - 1]);
        }

        return result;
    }
}
