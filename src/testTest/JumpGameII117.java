package testTest;

import java.util.Arrays;

public class JumpGameII117 {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int len = A.length;
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i < len;i++){
           int step = Integer.MAX_VALUE;
           for(int index = i - 1;index >=0;index--){
               if(A[index] < i - index){
                   continue;
               }
               step = Math.min(step,dp[index]);
           }
           if(step < Integer.MAX_VALUE){               
               dp[i] = step + 1;
           }
        }
        return dp[len - 1];
    }
}
