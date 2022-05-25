package testTest;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
       int len = nums.length;
       Arrays.sort(nums);
       int result = 0;
       int average = nums[len / 2];
      
       for(int i = 0;i < len;i++){
           result += Math.abs(nums[i] - average);
        }
       
       return result;
    }
}