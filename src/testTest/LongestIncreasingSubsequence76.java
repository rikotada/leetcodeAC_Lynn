package testTest;

import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingSubsequence76 {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        //dp表示长度为n时最小的上升序列末位是多少
        int[] dp = new int[n+1];
        for(int k = 1; k <= n;k++){
            dp[k] = Integer.MAX_VALUE;
        }
        int i = 0;
        int j = 1;
        for(i = 0;i <n;i++){
            int a = firstGreatThan(dp,nums[i]);
            dp[a] = nums[i];
        }
        i = 1;
        while(i<=n && dp[i] != Integer.MAX_VALUE){
              i++;
        }
        
        return i-1;
      
    }

    public int firstGreatThan(int[] dp,int num){
        int start = 1;
        int end = dp.length - 1;
        if(dp[start] >= num){
           return start;
        }
        while(start + 1 < end){
            if(dp[start + (end - start) / 2] >= num){
               end = start + (end - start) / 2;
            }
            else{
                start = start + (end - start) / 2;
            }
        }
        return end;
    }
}
