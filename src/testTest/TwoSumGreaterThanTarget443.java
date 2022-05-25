package testTest;

import java.util.Arrays;

public class TwoSumGreaterThanTarget443 {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int result = 0;
        while(left < right){
           while(left < right && nums[left] + nums[right] <= target){
               left++;
           }
           result += right - left;
           right--;
        }
        return result;
    }
}
