package testTest;

public class MaximumSubarray41 {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
             return 0;
        }
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int i = 1; i <= n;i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int minBefore = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for(int m = 1; m <= n;m++ ){
           if(prefix[m - 1] < minBefore){
                minBefore = prefix[m - 1];
           }
           result = Math.max(result,prefix[m] - minBefore);
        }
        return result;
    }
}
