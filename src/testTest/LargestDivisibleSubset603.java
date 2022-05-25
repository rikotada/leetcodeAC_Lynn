package testTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset603 {
    /**
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
             return result;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int i = 0;
        for(i = 0;i < n;i++){
           dp[i] = 1;
           prev[i] = -1;
        }
        for(i = 0;i < n;i++){
            int step = 1;
            for(int k = i - 1; k>=0;k--){
                if(nums[i] % nums[k] == 0 && dp[k]+1 > step){
                    step = dp[k]+1;
                    dp[i] = step;
                    prev[i] = k;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(i = 0;i <n;i++){
            if(dp[i] > max){
               max = dp[i];
               maxIndex = i;
            }
        }
        while(prev[maxIndex] != -1){
              result.add(nums[maxIndex]);
              maxIndex = prev[maxIndex];
        }
        result.add(nums[maxIndex]);
        return result;
    }
}
